package TDACola;


/**
 * Clase que implementa los m�todos para una cola con arreglo circular.
 * @author Selene
 * @param <E> Tipo de dato de los elementos a almacenar en la cola.
 */
public class Cola_con_arreglo_circular<E>implements Queue<E> {
	private int frente; private int rabo;
	private E q[];
	
	/**
	 * Se encarga de inicializar el frente, rabo de la cola y asignarle el tama�o al arreglo.
	 * @param tama�o Tama�o m�ximo que tomar� el arreglo de la cola
	 */
	public Cola_con_arreglo_circular(int tama�o) {
		frente=0;
		rabo=0;
		q = (E[]) new Object[tama�o];
	}
	
	/**
	 * Inicializa el tama�o del arreglo con el valor asignado
	 */
	public Cola_con_arreglo_circular() {
		this(150);
	}
	
	@Override
	public int size() {
		return ((q.length)-frente+rabo)% q.length;
	}
	
	@Override
	public boolean isEmpty(){
		return rabo==frente;
	}
	
	@Override
	public E front() throws EmptyQueueException {
		if (rabo==frente) throw new EmptyQueueException ("Cola vac�a");
		else return q[frente];
	}
	
	@Override
	public void enqueue(E element) {
		if (size()==(q.length-1)) resize();
		q[rabo]=element;
		rabo=(rabo+1) % q.length;
	}
	
	@Override
	public E dequeue() throws EmptyQueueException {
		if (rabo==frente) { throw new EmptyQueueException ("Cola vac�a");
		}else {
			E aux = q[frente];
			q[frente]=null;
			frente = ((frente+1)%(q.length));
			return aux;
		}
	}

	/**
	 * Redimensiona el arreglo en caso de que est� lleno
	 */
	private void resize() {
		E[] nuevo = (E[]) new Object[2*(q.length)];
		int tama�o = size();
		try {
			int i=0;
			while (rabo!=frente) {
				nuevo[i]=dequeue();
				i++;
			}
			q=nuevo; frente=0; rabo=tama�o;
		}catch(EmptyQueueException e) {}
	}
}

	


