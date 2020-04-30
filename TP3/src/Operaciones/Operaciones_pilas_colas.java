package Operaciones;
import TDACola.Queue;
import TDAPila.EmptyStackException;
import TDAPila.Pila_arreglo;
import TDAPila.Stack;
import TDACola.Cola_con_enlaces;
import TDACola.EmptyQueueException;
public class Operaciones_pilas_colas {
	public static boolean chequearFormato(Queue<Character> q, char x) {
		Stack<Character> pilaux = new Pila_arreglo<Character>();
		Queue<Character> colaux = new Cola_con_enlaces<Character>();
		boolean paso=false; boolean es=false;
		try {
			if (q.size()<4) return false;
			else{	
				
				while (!q.isEmpty()&&(!paso)) {
						Character auxi = q.dequeue();
						if ((auxi != x)&&(!paso)) {
							pilaux.push(auxi);
							colaux.enqueue(auxi);
						}else { 
							paso=true; 
							if (paso && !q.isEmpty()) {
								es=true;
							}
						}
				}
				while((es)&&(!pilaux.isEmpty())&&(!q.isEmpty())) {
						if (!(pilaux.pop()==q.dequeue())) es=false;
				}
				if ((q.size()!=colaux.size())||!es) { es=false;}
				else {
					while ((es)&&(!colaux.isEmpty())) {
	
							if (!(q.dequeue()==colaux.dequeue())) es=false;
					}
				}
				if (!(es&&q.isEmpty()&&colaux.isEmpty())) es =false;
			}
		}catch(EmptyQueueException e) {}
		catch (EmptyStackException e) {}

		return es;
	}
		public static void main(String[] args) {
	        Queue<Character> testQueue = new Cola_con_enlaces<Character>();
	        testQueue.enqueue('a');
	        testQueue.enqueue('b');
	        testQueue.enqueue('c');
	        testQueue.enqueue('$');
	        testQueue.enqueue('c');
	        testQueue.enqueue('b');
	        testQueue.enqueue('a');
	        testQueue.enqueue('a');
	        testQueue.enqueue('b');
	        testQueue.enqueue('c');
	        System.out.println(chequearFormato(testQueue,'$'));
	}
}