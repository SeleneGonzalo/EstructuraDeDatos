package TDALista;

/**
 * Clase que permite almacenar un elemento genérico y mantener referencia a un nodo anterior y siguiente en la lista enlazada.
 * @author Selene
 * @param <E> Tipo de dato a almacenar en el nodo
 */
public class DNodo<E> implements Position<E>{
	private E elemento;
	private DNodo<E> siguiente;
	private DNodo<E> anterior;
	
	/**
	 * Inicializa el nodo con los valores recibidos por parámetro
	 * @param elemento Elemento que se insertará en el nodo
	 * @param anterior Nodo anterior al actual
	 * @param siguiente Nodo siguiente al actual
	 */
	public DNodo(E elemento,DNodo<E> anterior,DNodo<E> siguiente) {
        this.elemento = elemento;
        this.siguiente = siguiente;
        this.anterior = anterior;
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
	public void setSiguiente (DNodo siguiente) {
		this.siguiente = siguiente;
	}
	
	/**
	 * Retorna el nodo siguiente al nodo actual
	 * @return Nodo sigueinte al actual
	 */
	public DNodo getSiguiente() {
		return this.siguiente;
	}
	
	/**
	 * Referencia el nodo actual a su anterior
	 * @param anterior Nodo anterior al actual
	 */
	public void setAnterior (DNodo anterior) {
		this.anterior = anterior;
	}
	
	/**
	 * Retorna el nodo anterior al nodo actual
	 * @return Nodo anterior al actual
	 */
	public DNodo getAnterior() {
		return this.anterior;
	}
	
	/**
	 * @return Elemento del nodo
	 */
	public E element() {
		return elemento;
	}
}