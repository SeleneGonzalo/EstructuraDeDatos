package TDALista;

import java.util.Iterator;

public class Lista_doble_enlazada<E> implements PositionList<E> {
	protected DNodo<E> header;
	protected DNodo<E> trailer;
	protected int size;
	
	public Lista_doble_enlazada() {
		header = new DNodo<E>(null,null,trailer);
		trailer= new DNodo<E>(null,header,null);
		header.setSiguiente(trailer);
		size =0;
	}
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public Position<E> first() throws EmptyListException{
		if (size==0) throw new EmptyListException ("La lista está vacía");
		else return header.getSiguiente();
	}
	
	public Position<E> last() throws EmptyListException{
		if (size==0) throw new EmptyListException("Lista vacía");
		else return trailer.getAnterior();
	}

	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> aux = null;
		if (size==0) throw new InvalidPositionException ("La pila está vacía");
		aux = checkPosition(p);
		if (aux.getSiguiente()==trailer) throw new BoundaryViolationException ("No hay siguiente elemento");
		aux=aux.getSiguiente();
		return aux;
	}

	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> aux = null;
		if (size==0) throw new InvalidPositionException ("La pila está vacía");
		aux = checkPosition(p);
		if (aux.getAnterior()==header) throw new BoundaryViolationException ("No hay anterior elemento");
		aux=aux.getAnterior();
		return aux;
	}

	public void addFirst(E element) {
		DNodo<E> siguiente = header.getSiguiente();
		DNodo<E> nuevo = new DNodo<E>(element,header,siguiente);
		header.setSiguiente(nuevo);
		siguiente.setAnterior(nuevo);
		size++;
	}

	public void addLast(E element) {
		DNodo<E> anterior = trailer.getAnterior();
		DNodo<E> nuevo = new DNodo<E>(element,anterior,trailer);
		trailer.setAnterior(nuevo);
		anterior.setSiguiente(nuevo);
		size++;
	}


	public void addAfter(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> pos = checkPosition(p);
		DNodo<E> nuevo= new DNodo<E>(element,pos,pos.getSiguiente());
		nuevo.getSiguiente().setAnterior(nuevo);
		pos.setSiguiente(nuevo);
		size++;
	}

	public void addBefore(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> pos = checkPosition(p);
		DNodo<E> nuevo= new DNodo<E>(element,pos.getAnterior(),pos);
		nuevo.getAnterior().setSiguiente(nuevo);
		pos.setAnterior(nuevo);
		size++;
	}


	public E remove(Position<E> p) throws InvalidPositionException {
		DNodo<E> aux = checkPosition(p);
		E auxiliar=aux.getElemento();
		aux.getAnterior().setSiguiente(aux.getSiguiente());
		aux.getSiguiente().setAnterior(aux.getAnterior());
		aux.setElemento(null);
		size--;
		return aux.getElemento();
	}


	public E set(Position<E> p, E element) throws InvalidPositionException {;
		DNodo<E> aux = checkPosition(p);
		E auxiliar = aux.getElemento();
		aux.setElemento(element);
		return auxiliar;
	}


	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> iterable;
		iterable = new Lista_doble_enlazada<Position<E>>();
		if (header.getSiguiente()!= null) {
			DNodo<E> actual=header.getSiguiente();
			while (actual != trailer) {
				iterable.addLast(actual);
				actual=actual.getSiguiente();
			}
		}
		return iterable;
	}
	
	private DNodo<E> checkPosition(Position<E>p) throws InvalidPositionException{
		try {
			if (p==null)throw new InvalidPositionException ("p posición nula");
			if (p.element()==null) throw new InvalidPositionException("p fue eliminada previamente");
			return (DNodo<E>) p;
		}catch (ClassCastException e) {
			throw new InvalidPositionException ("p no es un nodo de la lista");
		}
	}
	
	public void invertir() {
		invertirAux(header.getSiguiente(), this);
	}
	public PositionList<E> invertirAux(DNodo<E> nodo, PositionList<E> l){
		if (nodo != trailer) {
			l.addFirst(nodo.getElemento());
			invertirAux(nodo.getSiguiente(),l);
			try {
				remove (nodo);
			} catch (InvalidPositionException e) {}
		}
		return l;
	}
	
	public static void main (String []args) {
        Lista_doble_enlazada<Integer> a = new Lista_doble_enlazada<Integer>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);
        a.mostrar();
        System.out.println("ZIGZAG: ");
        Lista_doble_enlazada<Integer> a2 = (Lista_doble_enlazada<Integer>) a.zigzag();
        a2.mostrar();
    }
	public PositionList<E> zigzag(){
    	PositionList<E> l2 = new Lista_doble_enlazada<E>();
    	DNodo<E> primero = header.getSiguiente();
    	DNodo<E> ultimo = trailer.getAnterior();
    	return zigzagAux(primero,ultimo,l2);
    }
    private PositionList<E> zigzagAux(DNodo<E> cabeza, DNodo<E> rabo,PositionList<E> lista){
    	if ((size%2)==0) {
    		if (cabeza.getSiguiente()!=rabo) {
    			lista.addLast(cabeza.getElemento());
    			lista.addLast(rabo.getElemento());
    			zigzagAux(cabeza.getSiguiente(),rabo.getAnterior(),lista);
    		} else {
    			lista.addLast(cabeza.getElemento());
    			lista.addLast(rabo.getElemento());
    		}
    	} else {
    		if (cabeza!=rabo) {
    			lista.addLast(cabeza.getElemento());
    			lista.addLast(rabo.getElemento());
    			zigzagAux(cabeza.getSiguiente(),rabo.getAnterior(),lista);
    		}else {
    			lista.addLast(cabeza.getElemento());
    		}
    	}
    	return lista;
    }
    public void mostrar() {
        DNodo<E>aux=header.getSiguiente();
        while (aux!=trailer) {
            System.out.println(aux.getElemento());
            aux=aux.getSiguiente();
        }
        
    }
}
    
    
