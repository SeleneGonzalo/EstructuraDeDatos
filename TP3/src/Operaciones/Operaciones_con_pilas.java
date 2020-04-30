package Operaciones;
import TDAPila.EmptyStackException;
import TDAPila.Pila_con_enlaces;
import TDAPila.Stack;
public class Operaciones_con_pilas {
	public static void invertirArreglo(int [] a) throws EmptyStackException {
		Pila_con_enlaces<Integer> pce = new Pila_con_enlaces<Integer>();
		for (int i=0; i<a.length; i++) {
			pce.push(a[i]);
		}
		for (int i=0; i<a.length; i++) {
			a[i]=pce.pop();
		}
	}
	 public static <E> void invertir(Stack<E> p) {
		 Stack<E> pilaux, pilaux2;
		 pilaux = new Pila_con_enlaces<E>();
		 pilaux2 = new Pila_con_enlaces<E>();
		 mover(p,pilaux);
		 mover (pilaux,pilaux2);
		 mover(pilaux2,p);
	 }
	 private static <E> void mover (Stack<E> pilaone, Stack<E> pilatwo) {
		 try {
			 while (!pilaone.isEmpty()) pilatwo.push(pilaone.pop());
		 } catch (EmptyStackException e) {
			 e.printStackTrace();
		 }
	 }
	 private static Stack<Integer> aplanar(Stack<Stack<Integer>> pilaGeneral) {
	        Stack<Integer> pilanueva = new Pila_con_enlaces<Integer>();
	        try {
	            Stack<Integer> a;
	            a = pilaGeneral.pop();
	            aplanar(pilaGeneral);
	            aplanarEnteros(a, pilanueva);
	        }catch(EmptyStackException e) {
	            e.printStackTrace();
	        }
	        return pilanueva;
	 }
	    private static void aplanarEnteros(Stack<Integer> pila, Stack<Integer> pilanueva) {
	        try {
	            Integer a;
	            a = pila.pop();
	            aplanarEnteros(pila,pilanueva);
	            pilanueva.push(a);
	        }catch(EmptyStackException e) {
	            e.printStackTrace();
	        }
	    }
}
