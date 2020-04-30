package TDACola;
import TDAPila.EmptyStackException;
import TDAPila.Pila_con_enlaces;
import TDAPila.Stack;

public class Cola_con_pila<E> implements Queue<E>{
	private Stack<E> pila;
	
	public Cola_con_pila(){
		pila = new Pila_con_enlaces<E>();
	}
	public int size() {
		return pila.size();
	}
	public boolean isEmpty() {
		return pila.isEmpty();
	}
	
	public E front() throws EmptyQueueException{
		
		
		if (isEmpty()) {
			throw new EmptyQueueException("La cola está vacía");
		}else {
			E aux=null;
			Stack<E>auxiliar=pasarPila(pila);
		try {
			aux = auxiliar.pop();
		} catch (EmptyStackException e) {
			e.printStackTrace();
		}
		pila.push(aux);
		for (int i=0; i<pila.size();i++) {
			try {
				pila.push(auxiliar.pop());
			} catch (EmptyStackException e) {
				e.printStackTrace();
			}
		}
		return aux;
		}
	}
	public void enqueue(E element) {
		pila.push(element);
	}
	public E dequeue() throws EmptyQueueException{
		E aux=null;
		Stack<E> auxiliar = pasarPila(pila);
		if (isEmpty()) {throw new EmptyQueueException("Cola vacia");
		}else {
		try {
			aux = auxiliar.pop();
		} catch (EmptyStackException e) {
			e.printStackTrace();
		}
		pila = pasarPila(auxiliar);
		return aux;
		}
	}
	private Stack<E> pasarPila(Stack<E> pilactual) {
		Stack<E> auxiliar= new Pila_con_enlaces<E>();
		for (int i=0; i<=pilactual.size()+1; i++) {
			try{
				auxiliar.push(pilactual.pop());
			}catch(EmptyStackException e) {
				e.printStackTrace();
			}
		}
		return auxiliar;
	}
}

