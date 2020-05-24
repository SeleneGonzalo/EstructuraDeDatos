package TDALista;
/**
 * Clase que permite almacenar un elemento genérico y 
 * mantener referencia a un nodo siguiente en la lista enlazada.
 * @author Selene
 * @param <E> Tipo de dato a almacenar en el nodo
 */

public class Nodo<E> implements Position<E>{
	private E elemento;
	private Nodo<E> siguiente;
	
	/**
	 * Inserta el elemento al nodo y lo referencia al nodo siguiente
	 * @param elemento Elemento que se insetará en el nodo
	 * @param siguiente Nodo siguiente al actual
	 */
	public Nodo(E elemento,Nodo<E> siguiente) {
        this.elemento = elemento;
        this.siguiente = siguiente;
    }
	
	/**
	 * Inserta el elemento en el nodo
	 * @param elemento Elemento que se insertará en el nodo
	 */
	public void setElemento (E elemento) {
		this.elemento=elemento;
	}
	
	/**
	 * Retorna el elemento solicitado
	 * @return Elemento solicitado
	 */
	public E getElemento() {
		return elemento;
	}
	/**
	 * Referencia el nodo actual a su siguiente
	 * @param siguiente Nodo siguiente al actual
	 */
	public void setSiguiente (Nodo siguiente) {
		this.siguiente = siguiente;
	}
	
	/**
	 * Retorna el nodo siguiente al nodo actual
	 * @return Nodo sigueinte al actual
	 */
	public Nodo getSiguiente() {
		return this.siguiente;
	}
	
	/**
	 * @return Elemento del nodo
	 */
	public E element() {
		return elemento;
	}
}

