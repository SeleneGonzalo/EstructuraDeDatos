package TDALista;


public class DNodo<E> implements Position<E>{
	private E elemento;
	private DNodo<E> siguiente;
	private DNodo<E> anterior;
	
	public DNodo(E elemento,DNodo<E> anterior,DNodo<E> siguiente) {
        this.elemento = elemento;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
	public void setElemento (E elemento) {
		this.elemento=elemento;
	}
	public E getElemento() {
		return elemento;
	}
	public void setSiguiente (DNodo siguiente) {
		this.siguiente = siguiente;
	}
	public DNodo getSiguiente() {
		return this.siguiente;
	}
	public void setAnterior (DNodo anterior) {
		this.anterior = anterior;
	}
	public DNodo getAnterior() {
		return this.anterior;
	}
	public E element() {
		return elemento;
	}
}