package TDALista;

import java.util.Iterator;

public class Lista_simple_enlazada<E> implements PositionList <E>{
	private Nodo<E> primerElemento;
	
	public Lista_simple_enlazada() {
		primerElemento = null;
	}
	private Lista_simple_enlazada(Nodo<E> nodo) {
		primerElemento = nodo;
	}
	
	public int size() {
		int cant=0;
		Nodo<E> primer = primerElemento;
		while (primer!=null) {
			primer=primer.getSiguiente();
			cant++;
		}
		return cant;
	}
	
	public boolean isEmpty() {
		return primerElemento == null;
	}
	
	public Position<E> first() throws EmptyListException{
		if (primerElemento==null) throw new EmptyListException ("Lista vacía");
		return primerElemento;
	}
	
	public Position<E> last() throws EmptyListException{
		Nodo<E> temp = primerElemento;
		if (isEmpty()) throw new EmptyListException("Lista vacía");
		else {
			while(temp.getSiguiente() != null) 
				temp = temp.getSiguiente();
		}
		return temp;
	}
	
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		Nodo <E> nuevo = checkPosition(p);
		if (nuevo.getSiguiente()==null) throw new BoundaryViolationException ("No hay siguiente elemento");
		return nuevo.getSiguiente();
	}
	private Nodo<E> checkPosition(Position<E>p) throws InvalidPositionException{
		try {
			if (p==null)throw new InvalidPositionException ("Posición nula");
			if (p.element()==null) throw new InvalidPositionException("p fue eliminada previamente");
			return (Nodo<E>) p;
		}catch (ClassCastException e) {
			throw new InvalidPositionException ("p no es un nodo de la lista");
		}
	}
	
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
	
	public void addFirst(E element) {
		primerElemento = new Nodo<E>(element, primerElemento);
	}
	public void addLast(E element) {
		if (isEmpty()) addFirst(element);
		else {
			Nodo<E> p=primerElemento;
			while (p.getSiguiente()!=null)
				p=p.getSiguiente();
			p.setSiguiente(new Nodo<E>(element, null));
		}
	}
	public void addAfter(Position<E> p, E element) throws InvalidPositionException{
		Nodo<E> n = checkPosition(p);
		Nodo<E>nuevo = new Nodo<E>(element, null);
		nuevo.setSiguiente(n.getSiguiente());
		n.setSiguiente(nuevo);
	}
	
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

	public E set(Position<E> p, E element) throws InvalidPositionException{
		Nodo<E> aux = checkPosition (p);
		E retorno = aux.element();
		aux.setElemento(element);
		return retorno;
	}
	
	public Iterator<E> iterator(){
		return new ElementIterator<E>(this);
	}
	
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> iterable;
		iterable = new Lista_simple_enlazada<Position<E>>();
		Nodo<E> actual = primerElemento;
		while(actual != null) {
			iterable.addLast(actual);
			actual = actual.getSiguiente();
		}
		return iterable;
	}
	
	public Lista_simple_enlazada<E> clone(){
		Lista_simple_enlazada<E> clonada = new Lista_simple_enlazada<E>(primerElemento.clone());
		Nodo<E>aux = primerElemento.getSiguiente();
		while (aux != null) {
			clonada.addLast(aux.clone().getElemento());
			aux = aux.getSiguiente();
		}
		return clonada;
	}

	//Se asume que la lista tiene al menos un elemento
	public void eliminarConsecutivos(E e1, E e2) {
    	Nodo<E>aux=primerElemento;
    	Nodo<E> siguiente=null;
    	if (aux.getSiguiente()!=null) {
    		siguiente= aux.getSiguiente();
    	}
    	while (siguiente != null) {
    		if (aux.getElemento() == e1 && siguiente.getElemento() ==e2) {
    			try {
    				remove (aux);
    				if (siguiente.getSiguiente() != null)
    				aux = siguiente.getSiguiente();
    				remove (siguiente);
					siguiente = aux.getSiguiente();
				} catch (InvalidPositionException e) {} 
    		}else {
    			if (aux.getSiguiente()!=null && siguiente.getSiguiente()!=null) {
    			aux=aux.getSiguiente();
    			siguiente = siguiente.getSiguiente();
    			}
    		}
    	}
    	if (siguiente==null) {
			if (aux.getElemento() == e1 && siguiente.getElemento()== e2) {
    			try {
					remove (aux);
					remove (siguiente);
    			}catch(InvalidPositionException e) {}
			}
		}
	}
	public static void main (String []args) {
        Lista_simple_enlazada<Integer> a = new Lista_simple_enlazada<Integer>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);
        a.addLast(3);
        a.addLast(2);
        a.addLast(3);
        a.addLast(8);
        a.mostrar();
        a.eliminarConsecutivos(2,3);
        System.out.println("Eliminando consecutivos 1 y 2: ");
        a.mostrar();
    }
    public void mostrar() {
        Nodo<E>aux=primerElemento;
        while (aux!=null) {
            System.out.println(aux.getElemento());
            aux=aux.getSiguiente();
        }
    }
}
