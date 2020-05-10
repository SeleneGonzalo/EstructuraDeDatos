package TDALista;
import java.lang.*;
import java.util.*;

public class ElementIterator<E> implements Iterator<E>{
	protected PositionList <E> list;
	protected Position<E> cursor;
	public ElementIterator (PositionList <E> l){
		list=l;
		if (list.isEmpty()) cursor = null;
		else
			try {
				cursor = list.first();
			} catch (EmptyListException e) {}
	}
	
	public boolean hasNext() {
		return cursor != null;
	}
	
	public E next() throws NoSuchElementException{
		if (cursor==null) throw new NoSuchElementException ("No hay siguiente");
		E toReturn = cursor.element();
		try {
			cursor = (cursor==list.last()) ? null:list.next(cursor);
		} catch (EmptyListException e) {} catch (InvalidPositionException e) {} catch (BoundaryViolationException e) {}
		return toReturn;
	}
}