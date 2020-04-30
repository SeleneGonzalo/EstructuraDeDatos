package TDACola;

public class Cola_con_enlaces<E> implements Queue <E>{
	protected Nodo<E> head, tail;
	protected int tama�o;
	
	public Cola_con_enlaces() {
		tama�o=0;
		head=null; tail=null;
	}
	public int size() {
		return tama�o;
	}
	public boolean isEmpty() {
		return tama�o==0;
	}
	public E front() throws EmptyQueueException{
		if (isEmpty()) throw new EmptyQueueException ("La cola est� vac�a");
		else {
			return head.getElemento();
		}
	}
	public void enqueue(E element) {
		Nodo<E>nodo=new Nodo<E>();
		nodo.setElemento(element);
		nodo.setSiguiente(null);
		if (tama�o==0) {
			head=nodo;
		}else {
			tail.setSiguiente(nodo);	
		}
		tail=nodo;
		tama�o++;
	}
	public E dequeue() throws EmptyQueueException{
		if (tama�o==0) throw new EmptyQueueException ("La cola est� vac�a");
		else {
			E aux = head.getElemento();
			head=head.getSiguiente();
			tama�o--;
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
