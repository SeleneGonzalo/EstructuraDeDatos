package TDACola;

/**
 * Clase que implementa los métodos para una cola con enlaces.
 * @author Selene
 * @param <E> Tipo de dato de los elementos a almacenar en la cola.
 */
public class Cola_con_enlaces<E> implements Queue <E>{
	private Nodo<E> cabeza, cola;
	private int tamaño;
	
	/**
	 * Se encarga de inicializar la cantidad de elementos de la cola, asi como el primer y último nodo.
	 */
	public Cola_con_enlaces() {
		tamaño=0;
		cabeza=null; cola=null;
	}
	
	@Override
	public int size() {
		return tamaño;
	}
	
	@Override
	public boolean isEmpty() {
		return tamaño==0;
	}
	
	@Override
	public E front() throws EmptyQueueException{
		if (tamaño==0) throw new EmptyQueueException ("Cola vacía");
		else {
			return cabeza.getElemento();
		}
	}
	
	@Override
	public void enqueue(E element) {
		Nodo<E>nodo=new Nodo<E>();
		nodo.setElemento(element);
		nodo.setSiguiente(null);
		
		if (tamaño==0) { cabeza=nodo;
		}else { cola.setSiguiente(nodo);}
		
		cola=nodo;
		tamaño++;
	}
	
	@Override
	public E dequeue() throws EmptyQueueException{
		if (tamaño==0) throw new EmptyQueueException ("Cola vacía");
		else {
			E aux = cabeza.getElemento();
			cabeza=cabeza.getSiguiente();
			tamaño--;
			return aux;
		}
	}
}
