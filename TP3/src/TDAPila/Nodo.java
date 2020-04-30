package TDAPila;

public class Nodo<T> {
	private T elemento;
	private Nodo<T> siguiente;
	
	public Nodo() {
		
	}
	public void setElemento (T elemento) {
		this.elemento=elemento;
	}
	public T getElemento() {
		return elemento;
	}
	public void setSiguiente (Nodo siguiente) {
		this.siguiente = siguiente;
	}
	public Nodo getSiguiente() {
		return this.siguiente;
	}
}
