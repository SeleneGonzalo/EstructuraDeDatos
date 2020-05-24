package TDACola;
import TDAPila.EmptyStackException;
import TDAPila.Pila_arreglo;
import TDAPila.Pila_con_enlaces;
import TDAPila.Stack;

/**
 * Clase que representa internamente una cola a trav�s de una pila donde se almacenan los elementos.
 * @author Selene
 * @param <E> Tipo de dato que almacenar� la cola con pila
 */
public class Cola_con_pila<E> implements Queue<E>{
    private Stack<E> pila;
 
    /**
     * Crea una pila con arreglo.
     */
    public Cola_con_pila(){
        pila = new Pila_arreglo<E>();
    }
    
    @Override
    public int size(){
        return pila.size();
    }

    @Override
    public boolean isEmpty() {
         return pila.isEmpty();
    }
     
    @Override
    public E front() throws EmptyQueueException {
        Stack<E> pilaux = new Pila_con_enlaces<E>();
        E aux = null;
        if(pila.isEmpty()) throw new EmptyQueueException("Cola vac�a");
        else {
            int tama�o=pila.size();
            try {
	            for (int i =0; i<tama�o; i++) {
	                pilaux.push(pila.pop());
	            }
	            aux = pilaux.pop();
	            pila.push(aux);
	            for (int i =1; i<tama�o; i++){
	                 pila.push(pilaux.pop());
	            	}
	            } catch (EmptyStackException e) {}
        }
        return aux;
    }
       
    @Override
    public void enqueue(E element) {
       pila.push(element);
    }
     
    @Override
    public E dequeue() throws EmptyQueueException {
       Stack<E> pilaux = new Pila_con_enlaces<E>();
       E aux = null;
       if(pila.isEmpty()) throw new EmptyQueueException("Cola vac�a");
       else {
            int tama�o=pila.size();
            try {
            for (int i =0; i<tama�o; i++) {
                 pilaux.push(pila.pop());
            }
            aux = pilaux.pop();
            for (int i =1; i<tama�o; i++){
                pila.push(pilaux.pop());
            }
            
            } catch (EmptyStackException e) {}
       }
       return aux;
    }
}