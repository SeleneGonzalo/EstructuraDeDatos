package TDALista;
import java.util.Iterator;
/**
 * Clase que representa internamente una lista como una colección simplemente enlazada
 * @author Selene
 * @param <E> Tipo de dato que se almacenará en la lista
 */

public class Lista_simple_enlazada<E> implements PositionList <E>{
	private Nodo<E> primerElemento;
	
	/**
	 * Inicializa el primer elemento de la lista
	 */
	public Lista_simple_enlazada() {
		primerElemento = null;
	}
	/**
	 * Asigna un nodo al primer elemento de la lista 
	 * @param nodo Nodo que se le asignará al elemento
	 */
	private Lista_simple_enlazada(Nodo<E> nodo) {
		primerElemento = nodo;
	}
	
	@Override
	public int size() {
		int cantidad=0;
		Nodo<E> primerE = primerElemento;
		while (primerE!=null) {
			primerE=primerE.getSiguiente();
			cantidad++;
		}
		return cantidad;
	}
	
	@Override
	public boolean isEmpty() {
		return primerElemento == null;
	}
	
	@Override
	public Position<E> first() throws EmptyListException{
		if (primerElemento==null) throw new EmptyListException ("Lista vacía");
		return primerElemento;
	}
	
	@Override
	public Position<E> last() throws EmptyListException{
		Nodo<E> temporal = primerElemento;
		if (primerElemento==null) throw new EmptyListException("Lista vacía");
		else {
			while(temporal.getSiguiente() != null) 
				temporal = temporal.getSiguiente();
		}
		return temporal;
	}
	
	@Override
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		Nodo <E> nuevo = checkPosition(p);
		if (nuevo.getSiguiente()==null) throw new BoundaryViolationException ("No hay siguiente elemento");
		return nuevo.getSiguiente();
	}
	
	/**
	 * Examina que la posición recibida por parámetro sea válida
	 * @param pos Posición a examinar
	 * @return Posición en caso de ser válida, termina la ejecución con una excepción en caso contrario
	 * @throws InvalidPositionException si la posición recibida es nula, fue eliminada o no corresponde a un nodo de la lista.
	 */
	private Nodo<E> checkPosition(Position<E> pos) throws InvalidPositionException{
		try {
			if (pos==null)throw new InvalidPositionException ("Posición nula");
			if (pos.element()==null) throw new InvalidPositionException("p fue eliminada previamente");
			return (Nodo<E>) pos;
		}catch (ClassCastException e) {
			throw new InvalidPositionException ("p no es un nodo de la lista");
		}
	}
	
	@Override
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		Nodo<E> aux = null;
		try {
			checkPosition(p);
			if (p==first()) throw new BoundaryViolationException ("Posición primera");
			aux=primerElemento;
			while ((aux.getSiguiente()!=p) && (aux.getSiguiente()!=null)) aux = aux.getSiguiente();
			
			if (aux.getSiguiente()==null) throw new InvalidPositionException ("La posición no pertenece a la lista");
			
		} catch (EmptyListException e) {}
		return aux;
	}
	
	@Override
	public void addFirst(E element) {
		primerElemento = new Nodo<E>(element, primerElemento);
	}
	
	@Override
	public void addLast(E element) {
		if (primerElemento==null) addFirst(element);
		else {
			Nodo<E> p=primerElemento;
			while (p.getSiguiente()!=null)
				p=p.getSiguiente();
			p.setSiguiente(new Nodo<E>(element, null));
		}
	}
	
	@Override
	public void addAfter(Position<E> p, E element) throws InvalidPositionException{
		Nodo<E> n = checkPosition(p);
		Nodo<E>nuevo = new Nodo<E>(element, null);
		nuevo.setSiguiente(n.getSiguiente());
		n.setSiguiente(nuevo);
	}
	
	@Override
	public void addBefore(Position<E> p, E element) throws InvalidPositionException{
		checkPosition(p);
		try {
			if (p==first()) addFirst(element);
			else {
				try {
					addAfter(prev(p),element);
				} catch (InvalidPositionException e) {} catch (BoundaryViolationException e) {}
			}
			} catch (EmptyListException e) {}
	}
	
	@Override	
	public E remove(Position<E> p) throws InvalidPositionException{
		E aux = null;
		try {
			Nodo<E> n = checkPosition(p);
			if (p==first()) primerElemento=n.getSiguiente();
			else {
				checkPosition(prev(p)).setSiguiente(n.getSiguiente());
			}
			aux=p.element();
			n.setElemento(null);
			n.setSiguiente(null);
			} catch (BoundaryViolationException e) {}
		 catch (EmptyListException e) {}
		return aux;
	}

	@Override
	public E set(Position<E> p, E element) throws InvalidPositionException{
		Nodo<E> aux = checkPosition (p);
		E retorno = aux.element();
		aux.setElemento(element);
		return retorno;
	}
	
	@Override
	public Iterator<E> iterator(){
		return new ElementIterator<E>(this);
	}
	
	@Override
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> iterable;
		iterable = new Lista_simple_enlazada<Position<E>>();
		Nodo<E> nodo = primerElemento;
		while(nodo != null) {
			iterable.addLast(nodo);
			nodo = nodo.getSiguiente();
		}
		return iterable;
	}

}
