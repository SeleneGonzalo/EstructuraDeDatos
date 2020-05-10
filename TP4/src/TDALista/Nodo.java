package TDALista;


public class Nodo<E> implements Position<E>{
	private E elemento;
	private Nodo<E> siguiente;
	
	public Nodo(E elemento,Nodo<E> siguiente) {
        this.elemento = elemento;
        this.siguiente = siguiente;
    }
	public void setElemento (E elemento) {
		this.elemento=elemento;
	}
	public E getElemento() {
		return elemento;
	}
	public void setSiguiente (Nodo siguiente) {
		this.siguiente = siguiente;
	}
	public Nodo getSiguiente() {
		return this.siguiente;
	}
	public E element() {
		return elemento;
	}
	public Nodo<E> clone() {
		Nodo<E> toReturn;
	    if(siguiente!=null) {
	       toReturn = new Nodo<E>(elemento, siguiente.clone());
	    } else {
	           toReturn = new Nodo<E>(elemento,null);
	    }
	    return toReturn;
	    }
	} 

