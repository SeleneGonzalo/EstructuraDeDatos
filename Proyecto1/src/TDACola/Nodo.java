package TDACola;

/**
 * Permite almacenar un elemento genérico y mantener referencia a un nodo siguiente en la lista enlazada.
 * @author Selene
 * @param <T> Tipo de dato a almacenar en el nodo
 */

public class Nodo<T> {
	private T elemento;
	private Nodo<T> siguiente;
	
	/**
	 * Constructor de la calse
	 */
	public Nodo() {}
	
	/**
	 * Inserta un elemento en el nodo
	 * @param elemento Elemento a insertar
	 */
	public void setElemento (T elemento) {
		this.elemento=elemento;
	}
	
	/**
	 * Retorna el elemento del nodo
	 * @return Elemento solicitado
	 */
	public T getElemento() {
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
	 * Retorna el nodo siguiente al actual
	 * @return Nodo siguiente al actual
	 */
	public Nodo getSiguiente() {
		return this.siguiente;
	}
}

