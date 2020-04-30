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
		while (!q.isEmpty()&&(!paso)) {
			try {
				Character auxi = q.dequeue();
				if ((auxi != x)&&(!paso)) {
					pilaux.push(auxi);
					colaux.enqueue(auxi);
				}else { paso=true; es=true;}
			}catch (EmptyQueueException e) {}
		}
		while((!pilaux.isEmpty())&&(es)&&(!q.isEmpty())) {
			try {
				if (!(pilaux.pop()==q.dequeue())) es=false;
			} catch (EmptyStackException e) {
			} catch (EmptyQueueException e) {}
		}
		if (q.size()!=colaux.size()) { es=false;}
		else {
			while ((!colaux.isEmpty())&&(es)) {
				try {
					if (!(q.dequeue()==colaux.dequeue())) es=false;
				} catch (EmptyQueueException e) {}
			}
		}
		return es;
	}
		public static void main(String[] args) {
	        Queue<Character> testQueue = new Cola_con_enlaces<Character>();
	        
	        System.out.println(chequearFormato(testQueue,'$'));
	}
}