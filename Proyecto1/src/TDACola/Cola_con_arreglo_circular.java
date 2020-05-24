package TDACola;


/**
 * Clase que implementa los métodos para una cola con arreglo circular.
 * @author Selene
 * @param <E> Tipo de dato de los elementos a almacenar en la cola.
 */
public class Cola_con_arreglo_circular<E>implements Queue<E> {
	private int frente; private int rabo;
	private E q[];
	
	/**
	 * Se encarga de inicializar el frente, rabo de la cola y asignarle el tamaño al arreglo.
	 * @param tamaño Tamaño máximo que tomará el arreglo de la cola
	 */
	public Cola_con_arreglo_circular(int tamaño) {
		frente=0;
		rabo=0;
		q = (E[]) new Object[tamaño];
	}
	
	/**
	 * Inicializa el tamaño del arreglo con el valor asignado
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
		if (rabo==frente) throw new EmptyQueueException ("Cola vacía");
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
		if (rabo==frente) { throw new EmptyQueueException ("Cola vacía");
		}else {
			E aux = q[frente];
			q[frente]=null;
			frente = ((frente+1)%(q.length));
			return aux;
		}
	}

	/**
	 * Redimensiona el arreglo en caso de que esté lleno
	 */
	private void resize() {
		E[] nuevo = (E[]) new Object[2*(q.length)];
		int tamaño = size();
		try {
			int i=0;
			while (rabo!=frente) {
				nuevo[i]=dequeue();
				i++;
			}
			q=nuevo; frente=0; rabo=tamaño;
		}catch(EmptyQueueException e) {}
	}
}

	


