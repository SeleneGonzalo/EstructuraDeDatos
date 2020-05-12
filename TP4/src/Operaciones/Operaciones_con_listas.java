package Operaciones;
import java.util.Iterator;

import TDALista.DNodo;
import TDALista.EmptyListException;
import TDALista.Lista_doble_enlazada;
import TDALista.Lista_simple_enlazada;
import TDALista.Nodo;
import TDALista.PositionList;

public class Operaciones_con_listas {
	public boolean contenidoEInvertido(Lista_doble_enlazada<String> l1, Lista_doble_enlazada<String> l2) {
		boolean seCumple=true;
		if ((l1.size()*2)!=l2.size()) seCumple=false;
		else {
			DNodo<String> cabezal1=null;
			DNodo<String> cabezal2=null;
			DNodo<String> rabol2=null;
			if (l1.size()!=0) {
				try {
					cabezal1 = (DNodo<String>) l1.first();
					cabezal2 = (DNodo<String>)l2.first();
					rabol2= (DNodo<String>)l2.last();
					while(cabezal1!=null) {
						seCumple = ((cabezal1.getElemento() == cabezal2.getElemento()) && (cabezal1.getElemento()==rabol2.getElemento()));
						if (cabezal1.getSiguiente().getElemento()!=null) {
							cabezal1=cabezal1.getSiguiente();
							cabezal2=cabezal2.getSiguiente();
							rabol2=rabol2.getAnterior();
							}else {
								cabezal1=null;
							}
						}
				}catch (EmptyListException e) {}
			}
		}
		return seCumple;
	}
	
	public boolean contenidoInvertido(Lista_doble_enlazada<Character> l1, Lista_doble_enlazada<Character> l2) {
		boolean seCumple=true;
			Iterator<Character> it1;
			Iterator<Character> it2;
			if (l1.size()!=0) {
				seCumple=false;
			}else {
				it1 = l1.iterator();
				it2 = l2.iterator();
				while (it2.hasNext()&&seCumple) {
					if (!it1.next().equals(it2.next())) seCumple=false;
					if (seCumple) {
						it2=l2.iterator();
						seCumple=cumpleInverso(it1,it2,l1,l2,it2.next());
					}
				}
			}
		return seCumple;
	}
	private boolean cumpleInverso (Iterator<Character> i1,Iterator<Character> i2,PositionList<Character> list1,PositionList<Character> list2,Character e) {
		boolean cumple=true;
		if (i2.hasNext()) {
			Character elem=i2.next();
			cumpleInverso(i1,i2,list1,list2,elem);
			cumple = cumple && e.equals(i1.next());
		}
		return cumple;
	}
	public static Lista_simple_enlazada<Integer> intercalarSinRepetidos(Lista_simple_enlazada<Integer> l1, Lista_simple_enlazada<Integer> l2){
		Lista_simple_enlazada<Integer> retornable = new Lista_simple_enlazada<Integer>();
		Nodo<Integer> eleml1=null; Nodo<Integer> eleml2=null;
		try {
			eleml1=(Nodo<Integer>) l1.first();
			eleml2=(Nodo<Integer>)l2.first();
			while (eleml1!=null && eleml2!=null) {
				if (eleml1.getElemento()!=eleml2.getElemento()) {
					retornable.addLast(eleml1.getElemento());
					retornable.addLast(eleml2.getElemento());
				}else retornable.addLast(eleml1.getElemento());
				if (eleml1.getSiguiente()!=null && eleml2.getSiguiente()!=null) {
					eleml1=eleml1.getSiguiente();
					eleml2=eleml2.getSiguiente();
				}else eleml1=null;
			}
		} catch (EmptyListException e) {}
		return retornable;
		}
	
	public static void main (String args[]) {
		Lista_simple_enlazada<Integer> l1 = new Lista_simple_enlazada<Integer>();
		Lista_simple_enlazada<Integer> l2 = new Lista_simple_enlazada<Integer>();
		l1.addLast(1);
		l1.addLast(2);
		l1.addLast(3);
		l2.addLast(6);
		l2.addLast(7);
		l2.addLast(8);
		intercalarSinRepetidos(l1,l2).mostrar();
	}
	 public void mostrar(Lista_simple_enlazada<Integer>l) {
	        Nodo<Integer> aux;
			try {
				aux = (Nodo<Integer>) l.first();
				while (aux!=null) {
		           System.out.println(aux.getElemento());
		           aux=aux.getSiguiente();
				}
			} catch (EmptyListException e) {}  
	  }
	 
	 public static Lista_doble_enlazada<Integer> intercalar_ordenados_sin_repetidos(Lista_doble_enlazada<Integer> l1, Lista_doble_enlazada<Integer> l2){
	        Lista_doble_enlazada<Integer> l3 = new Lista_doble_enlazada<Integer>();
	        Iterator<Integer> i1 = l1.iterator();
	        Iterator<Integer> i2 = l2.iterator();
	        Integer nodo1;
	        Integer nodo2;
	        while(i1.hasNext() && i2.hasNext()) {
	            nodo1 = i1.next();
	            nodo2 = i2.next();
	            if(nodo1 == nodo2)
	                l3.addLast(nodo1);
	            else if (nodo1 < nodo2) {
	                l3.addLast(nodo1);
	                l3.addLast(nodo2);
	            }else {
	                l3.addLast(nodo2);
	                l3.addLast(nodo1);
	            }
	        }
	        return l3;
	    }
}

