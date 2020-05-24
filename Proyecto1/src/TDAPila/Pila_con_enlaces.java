package TDAPila;

/**
 * Clase que implementa los m�todos para una pila con enlaces.
 * @author Selene
 * @param <T> Tipo de dato de los elementos a almacenar en la pila.
 */
public class Pila_con_enlaces<T> implements Stack <T> {
	private Nodo<T> cabeza;
	private int tama�o;
	
	/**
	 * Se encarga de inicializar la cantidad de elementos de la pila y el primer nodo de la misma.
	 */
	public Pila_con_enlaces() {
		tama�o=0;
		cabeza=null;
	}
	
	@Override
	public int size() {
		return tama�o;
	}
	
	@Override
	public boolean isEmpty() {
		return cabeza==null;
	}
	
	@Override
	public T pop() throws EmptyStackException{
		if (cabeza==null) throw new EmptyStackException("Pila vac�a");
		else{
			T aux = cabeza.getElemento();
			cabeza = cabeza.getSiguiente();
			tama�o--;
			return aux;
		}
	}
	
	@Override
	public void push(T elemento){
		Nodo<T>aux= new Nodo<T>();
		aux.setSiguiente(cabeza);
		aux.setElemento(elemento);
		cabeza = aux; tama�o++;
	}
	
	@Override
	public T top() throws EmptyStackException{
		if (cabeza==null) throw new EmptyStackException("La pila est� vac�a");
		return cabeza.getElemento();
	}
}
