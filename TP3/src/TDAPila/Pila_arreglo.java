package TDAPila;
import java.util.*;
public class Pila_arreglo <E> implements Stack<E>{
	protected E datos[];
	protected int tamaño;
	public Pila_arreglo(int max) {
		tamaño=0;
		datos = (E[]) new Object[max];
	}
	public Pila_arreglo() {
		this(50);
	}
	public int size() {
		return tamaño;
	}
	public boolean isEmpty() {
		return tamaño==0;
	}
	public E top() throws EmptyStackException{
		if (isEmpty())
			throw new EmptyStackException("La pila está vacía");
			return datos[tamaño-1];
	}
	public void push (E elemento) {
		if (tamaño==datos.length) {
			redimensionar();
			datos[tamaño++]=elemento;
		}else {
			datos[tamaño++]=elemento;
		}
	}
	public E pop() throws EmptyStackException{
		if (isEmpty()){
			throw new EmptyStackException("La pila está vacía");
		}else {
			E aux = datos[tamaño-1];
			datos[tamaño-1]=null;
			tamaño--;
			return aux;
		}
	}
	public void invertir() {
		int fin = tamaño;
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
		E[] nuevo = (E[]) new Object [tamaño+50];
		for (int i=0; i<tamaño;i++)
			nuevo[i]=datos[i];
			datos=nuevo;
	}
	
}