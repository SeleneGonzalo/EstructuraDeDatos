package TDALista;
import java.lang.*;
import java.util.*;

/**
 * Clase que implementa los métodos necesarios para que una colección sea iterable
 * @author Selene
 * @param <E> Tipo de dato que se almacenará en la lista
 */
public class ElementIterator<E> implements Iterator<E>{
	private PositionList <E> lista;
	private Position<E> cursor;
	
	/**
	 * Inicializa el cursor en el primer elemento de la lista, asigna null en caso de que la lista esté vacía
	 * @param l Lista a iterar
	 */
	public ElementIterator (PositionList <E> l){
		lista=l;
		if (lista.isEmpty()) cursor = null;
		else
			try {
				cursor = lista.first();
			} catch (EmptyListException e) {}
	}
	
	/**
	 * Retorna verdadero si el cursor puede seguir avanzando (hay próximo elemento), devuelve falso en caso contrario
	 */
	public boolean hasNext() {
		return cursor != null;
	}
	
	/**
	 * Retorna el siguiente elemento al actual
	 * @throws NoSuchElementException en caso de que no haya siguiente elemento
	 */
	public E next() throws NoSuchElementException{
		if (cursor==null) throw new NoSuchElementException ("No hay siguiente");
		E retornable = cursor.element();
		try {
			cursor = (cursor==lista.last()) ? null:lista.next(cursor);
		} catch (EmptyListException e) {} catch (InvalidPositionException e) {} catch (BoundaryViolationException e) {}
		return retornable;
	}
}