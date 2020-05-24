package TDACola;

/**
 * Clase que implementa los m�todos para una cola con enlaces.
 * @author Selene
 * @param <E> Tipo de dato de los elementos a almacenar en la cola.
 */
public class Cola_con_enlaces<E> implements Queue <E>{
	private Nodo<E> cabeza, cola;
	private int tama�o;
	
	/**
	 * Se encarga de inicializar la cantidad de elementos de la cola, asi como el primer y �ltimo nodo.
	 */
	public Cola_con_enlaces() {
		tama�o=0;
		cabeza=null; cola=null;
	}
	
	@Override
	public int size() {
		return tama�o;
	}
	
	@Override
	public boolean isEmpty() {
		return tama�o==0;
	}
	
	@Override
	public E front() throws EmptyQueueException{
		if (tama�o==0) throw new EmptyQueueException ("Cola vac�a");
		else {
			return cabeza.getElemento();
		}
	}
	
	@Override
	public void enqueue(E element) {
		Nodo<E>nodo=new Nodo<E>();
		nodo.setElemento(element);
		nodo.setSiguiente(null);
		
		if (tama�o==0) { cabeza=nodo;
		}else { cola.setSiguiente(nodo);}
		
		cola=nodo;
		tama�o++;
	}
	
	@Override
	public E dequeue() throws EmptyQueueException{
		if (tama�o==0) throw new EmptyQueueException ("Cola vac�a");
		else {
			E aux = cabeza.getElemento();
			cabeza=cabeza.getSiguiente();
			tama�o--;
			return aux;
		}
	}
}
