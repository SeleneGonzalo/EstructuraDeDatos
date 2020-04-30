package TDACola;

public class Cola_con_enlaces<E> implements Queue <E>{
	protected Nodo<E> head, tail;
	protected int tamaño;
	
	public Cola_con_enlaces() {
		tamaño=0;
		head=null; tail=null;
	}
	public int size() {
		return tamaño;
	}
	public boolean isEmpty() {
		return tamaño==0;
	}
	public E front() throws EmptyQueueException{
		if (isEmpty()) throw new EmptyQueueException ("La cola está vacía");
		else {
			return head.getElemento();
		}
	}
	public void enqueue(E element) {
		Nodo<E>nodo=new Nodo<E>();
		nodo.setElemento(element);
		nodo.setSiguiente(null);
		if (tamaño==0) {
			head=nodo;
		}else {
			tail.setSiguiente(nodo);	
		}
		tail=nodo;
		tamaño++;
	}
	public E dequeue() throws EmptyQueueException{
		if (tamaño==0) throw new EmptyQueueException ("La cola está vacía");
		else {
			E aux = head.getElemento();
			head=head.getSiguiente();
			tamaño--;
			return aux;
		}
	}
	public void invertir() {
		if (!isEmpty()) {
			E auxiliar;
			try {
				auxiliar = dequeue();
				invertir();
				enqueue(auxiliar);
			} catch (EmptyQueueException e) {}
		}
	}
}
