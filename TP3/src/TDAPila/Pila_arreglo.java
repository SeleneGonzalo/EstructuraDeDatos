package TDAPila;
import java.util.*;
public class Pila_arreglo <E> implements Stack<E>{
	protected E datos[];
	protected int tama�o;
	public Pila_arreglo(int max) {
		tama�o=0;
		datos = (E[]) new Object[max];
	}
	public Pila_arreglo() {
		this(50);
	}
	public int size() {
		return tama�o;
	}
	public boolean isEmpty() {
		return tama�o==0;
	}
	public E top() throws EmptyStackException{
		if (isEmpty())
			throw new EmptyStackException("La pila est� vac�a");
			return datos[tama�o-1];
	}
	public void push (E elemento) {
		if (tama�o==datos.length) {
			redimensionar();
			datos[tama�o++]=elemento;
		}else {
			datos[tama�o++]=elemento;
		}
	}
	public E pop() throws EmptyStackException{
		if (isEmpty()){
			throw new EmptyStackException("La pila est� vac�a");
		}else {
			E aux = datos[tama�o-1];
			datos[tama�o-1]=null;
			tama�o--;
			return aux;
		}
	}
	public void invertir() {
		int fin = tama�o;
		for (int i=0; fin-i>=1; i++,fin--) {
			swap (i,fin);
		}
	}
	private void swap(int p1, int p2) {
		E aux = datos[p1];
		datos[p1] = datos[p2];
		datos [p2] = aux;
	}
	private void redimensionar() {
		E[] nuevo = (E[]) new Object [tama�o+50];
		for (int i=0; i<tama�o;i++)
			nuevo[i]=datos[i];
			datos=nuevo;
	}
	
}