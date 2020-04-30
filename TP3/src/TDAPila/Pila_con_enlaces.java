package TDAPila;

public class Pila_con_enlaces<T> implements Stack <T> {
	protected Nodo<T> head;
	protected int tama�o;
	public Pila_con_enlaces() {
		tama�o=0;
		head=null;
	}
	public int size() {
		return tama�o;
	}
	public boolean isEmpty() {
		return head==null;
	}
	public T pop() throws EmptyStackException{
		if (isEmpty())
			throw new EmptyStackException("La pila est� vac�a");
		else{
			T aux = head.getElemento();
			head = head.getSiguiente();
			tama�o--;
			return aux;
		}
	}
	public void push(T elemento){
		Nodo<T>aux= new Nodo<T>();
		aux.setSiguiente(head);
		aux.setElemento(elemento);
		head = aux; tama�o++;
	}
	public T top() throws EmptyStackException{
		if (isEmpty())
			throw new EmptyStackException("La pila est� vac�a");
		return head.getElemento();
	}
}
