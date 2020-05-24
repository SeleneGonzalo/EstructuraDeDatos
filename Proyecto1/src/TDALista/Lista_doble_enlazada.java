package TDALista;
import java.util.Iterator;

/**
 * Clase que representa internamente una lista como una colección doblemente enlazada
 * @author Selene
 * @param <E> Tipo de dato que se almacenará en la lista
 */
public class Lista_doble_enlazada<E> implements PositionList<E> {
	private DNodo<E> header;
	private DNodo<E> trailer;
	private int size;
	
	/**
	 * Inicializa el primer y último nodo de la lista.
	 */
	public Lista_doble_enlazada() {
		header = new DNodo<E>(null,null,trailer);
		trailer= new DNodo<E>(null,header,null);
		header.setSiguiente(trailer);
		size =0;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size==0;
	}
	
	@Override
	public Position<E> first() throws EmptyListException{
		if (size==0) throw new EmptyListException ("Lista vacía");
		else return header.getSiguiente();
	}
	
	@Override
	public Position<E> last() throws EmptyListException{
		if (size==0) throw new EmptyListException("Lista vacía");
		else return trailer.getAnterior();
	}
	
	@Override
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> aux = null;
		
		if (size==0) throw new InvalidPositionException ("Lista vacía");
		aux = checkPosition(p);
		
		if (aux.getSiguiente()==trailer) throw new BoundaryViolationException ("No hay siguiente elemento");
		aux=aux.getSiguiente();
		
		return aux;
	}

	@Override
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> aux = null;
		
		if (size==0) throw new InvalidPositionException ("Lista vacía");
		aux = checkPosition(p);
		
		if (aux.getAnterior()==header) throw new BoundaryViolationException ("No hay anterior elemento");
		aux=aux.getAnterior();
		
		return aux;
	}

	@Override
	public void addFirst(E element) {
		DNodo<E> siguiente = header.getSiguiente();
		DNodo<E> nuevo = new DNodo<E>(element,header,siguiente);
		header.setSiguiente(nuevo);
		siguiente.setAnterior(nuevo);
		
		size++;
	}

	@Override
	public void addLast(E element) {
		DNodo<E> anterior = trailer.getAnterior();
		DNodo<E> nuevo = new DNodo<E>(element,anterior,trailer);
		trailer.setAnterior(nuevo);
		anterior.setSiguiente(nuevo);
		
		size++;
	}

	@Override
	public void addAfter(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> pos = checkPosition(p);
		DNodo<E> nuevo= new DNodo<E>(element,pos,pos.getSiguiente());
		nuevo.getSiguiente().setAnterior(nuevo);
		pos.setSiguiente(nuevo);
		
		size++;
	}

	@Override
	public void addBefore(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> pos = checkPosition(p);
		DNodo<E> nuevo= new DNodo<E>(element,pos.getAnterior(),pos);
		nuevo.getAnterior().setSiguiente(nuevo);
		pos.setAnterior(nuevo);
		
		size++;
	}

	@Override
	public E remove(Position<E> p) throws InvalidPositionException {
		DNodo<E> aux = checkPosition(p);
		E auxiliar=aux.getElemento();
		aux.getAnterior().setSiguiente(aux.getSiguiente());
		aux.getSiguiente().setAnterior(aux.getAnterior());
		aux.setElemento(null);
		
		size--;
		return aux.getElemento();
	}

	@Override
	public E set(Position<E> p, E element) throws InvalidPositionException {;
		DNodo<E> aux = checkPosition(p);
		E auxiliar = aux.getElemento();
		aux.setElemento(element);
		return auxiliar;
	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}
	
	@Override
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> iterable;
		iterable = new Lista_doble_enlazada<Position<E>>();
		if (header.getSiguiente()!= null) {
			DNodo<E> nodo=header.getSiguiente();
			while (nodo != trailer) {
				iterable.addLast(nodo);
				nodo=nodo.getSiguiente();
			}
		}
		return iterable;
	}
	
	/**
	 * Examina que la posición recibida por parámetro sea válida
	 * @param pos Posición a examinar
	 * @return Posición en caso de ser válida, termina la ejecución con una excepción en caso contrario
	 * @throws InvalidPositionException si la posición recibida es nula, fue eliminada o no corresponde a un nodo de la lista.
	 */
	private DNodo<E> checkPosition(Position<E>pos) throws InvalidPositionException{
		try {
			if (pos==null)throw new InvalidPositionException ("posición nula");
			if (pos.element()==null) throw new InvalidPositionException("pos fue eliminada previamente");
			return (DNodo<E>) pos;
		}catch (ClassCastException e) {
			throw new InvalidPositionException ("pos no es un nodo de la lista");
		}
	}
}
    
    
