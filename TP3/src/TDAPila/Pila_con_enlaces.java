package TDAPila;

public class Pila_con_enlaces<T> implements Stack <T> {
	protected Nodo<T> head;
	protected int tamaño;
	public Pila_con_enlaces() {
		tamaño=0;
		head=null;
	}
	public int size() {
		return tamaño;
	}
	public boolean isEmpty() {
		return head==null;
	}
	public T pop() throws EmptyStackException{
		if (isEmpty())
			throw new EmptyStackException("La pila está vacía");
		else{
			T aux = head.getElemento();
			head = head.getSiguiente();
			tamaño--;
			return aux;
		}
	}
	public void push(T elemento){
		Nodo<T>aux= new Nodo<T>();
		aux.setSiguiente(head);
		aux.setElemento(elemento);
		head = aux; tamaño++;
	}
	public T top() throws EmptyStackException{
		if (isEmpty())
			throw new EmptyStackException("La pila está vacía");
		return head.getElemento();
	}
}
