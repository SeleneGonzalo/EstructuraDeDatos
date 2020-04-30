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
		 }
	 }
	 private static Stack<Integer> aplanar(Stack<Stack<Integer>> pilaGeneral,Stack<Integer> pilanueva) {
	        try {
	            Stack<Integer> a;
	            a = pilaGeneral.pop();
	            aplanar(pilaGeneral,pilanueva);
	            aplanarEnteros(a, pilanueva);
	        }catch(EmptyStackException e) {
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
	        }
	    }
	    
	    public static void main(String[] args) {
	        Stack<Stack<Integer>> Principal = new Pila_con_enlaces<Stack<Integer>>();
	        Stack<Integer> A = new Pila_con_enlaces<Integer>();
	        Stack<Integer> B = new Pila_con_enlaces<Integer>();
	        Stack<Integer> C = new Pila_con_enlaces<Integer>();

	        A.push(1);
	        A.push(2);
	        A.push(3);

	        B.push(4);
	        B.push(5);
	        B.push(6);

	        C.push(7);
	        C.push(8);
	        C.push(9);

	        Principal.push(A);
	        Principal.push(B);
	        Principal.push(C);
	        

	        Stack<Integer> Aplanado = new Pila_con_enlaces<Integer>();
	        Aplanado = aplanar(Principal,Aplanado);
	        try {
				System.out.println(Aplanado.pop());
				System.out.println(Aplanado.pop());
				System.out.println(Aplanado.pop());
				System.out.println(Aplanado.pop());
				System.out.println(Aplanado.pop());
				System.out.println(Aplanado.pop());
				System.out.println(Aplanado.pop());
				System.out.println(Aplanado.pop());
				System.out.println(Aplanado.pop());
			} catch (EmptyStackException e) {
			}

	        System.out.println(Aplanado.size());
	    }
}
