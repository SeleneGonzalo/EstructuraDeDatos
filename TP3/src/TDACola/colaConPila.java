package TDACola;
 
import TDAPila.EmptyStackException;
import TDAPila.Pila_arreglo;
import TDAPila.Pila_con_enlaces;
import TDAPila.Stack;
 
public class colaConPila<E> implements Queue<E>{
       private Stack<E> pila;
 
       public colaConPila(){
          pila = new Pila_arreglo<E>();
       }
 
       public int size(){
          return pila.size();
       }
 
       public boolean isEmpty() {
            return pila.isEmpty();
       }
       
       public E front() throws EmptyQueueException {
           Stack<E> pilaux = new Pila_con_enlaces<E>();
            E aux = null;
            if(isEmpty())
                throw new EmptyQueueException("Cola vacía");
            else {
               int tamaño=pila.size();
                for (int i =0; i<tamaño; i++)
                    try {
                        pilaux.push(pila.pop());
                    } catch (EmptyStackException e) {
                        e.printStackTrace();
                    }
               
                try {
                    aux = pilaux.pop();
                    pila.push(aux);
                } catch (EmptyStackException e) {
                    e.printStackTrace();
                }
               
                for (int i =1; i<tamaño; i++){
                    try {
                        pila.push(pilaux.pop());
                    } catch (EmptyStackException e) {
                        e.printStackTrace();
                    }
                }
            }
            return aux;
        }
       
        public void enqueue(E element) {
            pila.push(element);
        }
       
        public E dequeue() throws EmptyQueueException {
            Stack<E> pilaux = new Pila_con_enlaces<E>();
            E aux = null;
            if(isEmpty())
                throw new EmptyQueueException("Cola vacía");
            else {
               int tamaño=pila.size();
                for (int i =0; i<tamaño; i++)
                    try {
                        pilaux.push(pila.pop());
                    } catch (EmptyStackException e) {
                        e.printStackTrace();
                    }
               
                try {
                    aux = pilaux.pop();
                } catch (EmptyStackException e) {
                    e.printStackTrace();
                }
               
                for (int i =1; i<tamaño; i++){
                    try {
                        pila.push(pilaux.pop());
                    } catch (EmptyStackException e) {
                        e.printStackTrace();
                    }
                }
            }
            return aux;
        }
       
}
