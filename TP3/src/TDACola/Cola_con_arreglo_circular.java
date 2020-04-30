package TDACola;

import TDAPila.EmptyStackException;

public class Cola_con_arreglo_circular<E>implements Queue<E> {
	protected int f; protected int r;
	protected E q[];
	public Cola_con_arreglo_circular(int max) {
		f=0;
		r=0;
		q = (E[]) new Object[max];
	}
	public Cola_con_arreglo_circular() {
		this(100);
	}
	public int size() {
		return ((q.length)-f+r)% q.length;
	}
	public boolean isEmpty(){
		return r==f;
	}
	public E front() throws EmptyQueueException {
		if (isEmpty()) throw new EmptyQueueException ("La cola est� vac�a");
		else return q[f];
	}
	public void enqueue(E element) {
		if (size()==(q.length-1)) 
			resize();
		
		q[r]=element;
		r= (r+1) % q.length;
	}
	public E dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException ("La cola est� vac�a");
		}else {
			E aux = q[f];
			q[f]=null;
			f = ((f+1)%(q.length));
			return aux;
		}
	}

	private void resize() {
		E[] nuevo = (E[]) new Object[2*(q.length)];
		int tama�o = size();
		try {
			int i=0;
			while (!isEmpty()) {
				nuevo[i]=dequeue();
				i++;
			}
			q=nuevo;
			f=0;
			r=tama�o;
		}catch(EmptyQueueException e) {}
	}
}

	


