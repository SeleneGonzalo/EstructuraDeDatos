package Logica;
import TDALista.BoundaryViolationException;
import TDALista.EmptyListException;
import TDALista.InvalidPositionException;
import TDALista.Lista_doble_enlazada;
import TDALista.Position;
import TDALista.PositionList;
import TDAPila.EmptyStackException;
import TDAPila.Pila_con_enlaces;
import TDAPila.Stack;

/**
 * Clase que implementa operaciones con diferentes tipos de datos abstractos.
 * @author Selene
 */
public class Logica {
	/**
	 * Se encarga de examinar una cadena recibida por par�metro y decidir si cumple o no con el formato solicitado
	 * @param cad Cadena a la cual se le validar� su formato
	 * @return Retorna verdadero en caso de que el formato de la cadena cumpla con el pedido, devuelve falso en caso contrario.
	 */
	 public static boolean chequear_cadena(String cad) {
		 int lector=0; 
		 boolean cumpleCondicion=true; boolean leyoZ=false; boolean leyoX= true;
		 Character caracter = null;
		 cumpleCondicion = cad.length()>=3; //El tama�o m�nimo de una cadena v�lida es 3, si es menor a dicha longitud, no cumple condici�n
		 while (leyoX && lector < cad.length() && cumpleCondicion) { //Condici�n que controla la validez de cada cadena Ai
			 leyoX = false; leyoZ = false;
	 		 PositionList<Character> listaCadena = new Lista_doble_enlazada<Character>();
			 try {
				//Comienza a validar la parte A1 (CzCC)
				 while (lector < cad.length() && !leyoZ && cumpleCondicion) { //Controla que la lista se cargue con la cadena hasta el separador 'z'
					 caracter = cad.charAt(lector++);
					 if (caracter == 'a' || caracter == 'b' || caracter == 'z') {
						listaCadena.addLast(caracter);
						leyoZ = caracter == 'z';
					 } else cumpleCondicion = false;
				 }
				 cumpleCondicion = leyoZ; //Cumple condici�n toma el valor verdadero o falso si ley� o no el separador 'z' en la cadena, respectivamente
				 if (cumpleCondicion) {
					 Position<Character> auxiliar1=null;
					 if (!listaCadena.isEmpty()) auxiliar1 = listaCadena.first();
					 while (cumpleCondicion && lector < cad.length() && auxiliar1 != null && (caracter != 'x') && auxiliar1.element() != 'z') { //Controla que lo que sigue en la cadena sea lo mismo
						 caracter = cad.charAt(lector++);																							//que est� cargado en la lista para que se cumpla CzC
						 if (caracter == auxiliar1.element()) {
							 listaCadena.addLast(caracter);
							 auxiliar1 = listaCadena.next(auxiliar1);
						 }else cumpleCondicion = false;
					 }
					 cumpleCondicion = cumpleCondicion && auxiliar1.element() == 'z';
					 if (!listaCadena.isEmpty()) auxiliar1 = listaCadena.first();
					 while (cumpleCondicion && lector < cad.length() && auxiliar1 != null && (caracter != 'x') && auxiliar1.element() != 'z') { //Controla que lo que sigue en la cadena sea lo mismo que est� cargado
						 caracter = cad.charAt(lector++);																							//en la lista por segunda vez ya que debe cumplirse CzCC
						 if (caracter == auxiliar1.element()) {
							 listaCadena.addLast(caracter);
							 auxiliar1 = listaCadena.next(auxiliar1);
						 }else cumpleCondicion = false;
					 } 
				 }
				 cumpleCondicion = cumpleCondicion && lector < cad.length() && cad.charAt(lector) == 'x'; //Para que se cumpla la condici�n debe haber un separador 'x' en esta
				 if (cumpleCondicion) cad.charAt(lector++);												 // instancia, debe respetar A1xA'1
				 Stack<Character> pilaControla = new Pila_con_enlaces<Character>();						//Crea una pila y la carga con los elementos que est�n del lado derecho de 'x'
				 while (lector < cad.length() && caracter != 'x' && cumpleCondicion) {
					  caracter = cad.charAt(lector++);
					  if(caracter!='x') {
						  if (caracter == 'a' || caracter == 'b' || caracter == 'z')
							  pilaControla.push(caracter);
						  else cumpleCondicion = false;
					  }
				 }		
				 cumpleCondicion = cumpleCondicion && !pilaControla.isEmpty();
				 //Comienza la validaci�n de A1=A'1 (CCzC)
				 Position<Character> lectorLista = listaCadena.first(); 
				 while ((cumpleCondicion) && (listaCadena.size() > 1) && (!pilaControla.isEmpty())) {
					 cumpleCondicion = (lectorLista.element() == pilaControla.pop()); //Controla que los elementos almacenados coincidan con el contenido de la lista,
					 if(cumpleCondicion && listaCadena.last() != lectorLista)		// ya que los elementos en la pila quedaron invertidos, A1 debe ser igual a A'1
							 lectorLista = listaCadena.next(lectorLista); 
				 }
				 
				 if (caracter =='x') { 				//Controla que, si estamos posicionados en un separador 'x', haya mas elementos,
					if ((lector+1)<cad.length()){	////ya que una cadena terminada en 'x' no es v�lida
						leyoX = true;
						caracter = cad.charAt(lector);
				 	} else cumpleCondicion = false;
				 } 
			 }catch (EmptyListException | InvalidPositionException | BoundaryViolationException | EmptyStackException e) {}
		 	}
		 return cumpleCondicion;
	 }
	 /**
	  * Se encarga de retornar el resultado de un m�todo auxiliar invocado.
	  * @param <E> Tipo de dato que almacenar� la lista
	  * @param l1 Lista que se utilizar� en el m�todo
	  * @return Una nueva lista con los elementos de la lista recibida por par�metro con el formato correspondiente.
	  */
	 public static <E>PositionList<E> zigzag (PositionList<E> l1){
		 PositionList<E> toReturn = new Lista_doble_enlazada<E>(); 
		 Position<E> primero = null; Position<E> ultimo = null; 
		 if (l1.size() > 1) {  //Si la lista tiene al menos dos elementos, obtengo el primer y �ltimo y la variable a retornar pasa
			 try {				// a valer lo que devuelva el m�todo auxiliar
			    primero = l1.first(); 
			    ultimo = l1.last(); 	
			 } catch (EmptyListException e) {}
			 toReturn = zigzagAux(primero,ultimo,toReturn,l1); //Retorna el resultado que devuelve el m�todo auxiliar
		 } else toReturn = l1; //Si la lista tiene un solo elemento, retorno dicha lista con dicho elemento
		 return toReturn;
	 }
	 
	 /**
	  * Retorna una nueva lista con los elementos de una lista recibida por par�metro con el formato correspondiente
	  * @param <E> Tipo de dato que almacenar� la lista
	  * @param cabeza Primer elemento de la lista
	  * @param rabo �ltimo elemento de la lista
	  * @param listaRetornable Lista que debe retornar
	  * @param lista1 Lista recibida por par�metro en el m�todo que invoca a zigzagAux
	  * @return Retorna la lista con el formato solicitado
	  */
	 private static <E>PositionList<E> zigzagAux(Position<E> cabeza, Position<E> rabo,PositionList<E> listaRetornable, PositionList<E> lista1){
		 try {
			 if ((lista1.size()%2)==0) {            //Si la lista recibida por par�metro tiene una cantidad par de elementos
		    	if (lista1.next(cabeza) != rabo) {  //Y si el siguiente elemento del primero de la lista no es el �ltimo, es decir, puede obtener el siguiente
		    		listaRetornable.addLast(cabeza.element()); //Agrega el primer elemento
		    		listaRetornable.addLast(rabo.element());   //seguido del �ltimo
		    		zigzagAux(lista1.next(cabeza),lista1.prev(rabo),listaRetornable,lista1); //Llama nuevamente al mismo m�todo, pero esta vez con el elemento
		    	} else {																	// siguiente al primero, el elemento anterior al �ltimo, la lista
		    		listaRetornable.addLast(cabeza.element());								//retornable actualizada y la lista original
		    		listaRetornable.addLast(rabo.element());
		    		}
		    } else {      					//Si la lista tiene cantidad impar de elementos
		    	if (cabeza!=rabo) {			//Y si el primer elemento no es el �ltimo
		    		listaRetornable.addLast(cabeza.element());	//Agrega el primer elemento
		    		listaRetornable.addLast(rabo.element());	//seguido del �ltimo
		    		zigzagAux(lista1.next(cabeza),lista1.prev(rabo),listaRetornable,lista1); 
		    	}else {																		
		    		listaRetornable.addLast(cabeza.element());								
		    		//Si el primer elemento es el �ltimo, lo agrego al final de la lista
		    	}
		    }
		 }catch (InvalidPositionException | BoundaryViolationException e) {}
	    return listaRetornable;
	  }
	 
	 /**
	  * Se encarga de devolver una lista ordenada de forma descendente con los elementos intercalados de las listas recibidas por par�metro.
	  * @param l1 Lista n�mero 1
	  * @param l2 Lista n�mero 2
	  * @return Una nueva lista con los elementos de las listas l1 y l2 intercalados y de forma descendente
	  */
	 public static PositionList<Integer> intercalar (PositionList <Integer> l1, PositionList<Integer> l2){
		 PositionList<Integer> toReturnLista = new Lista_doble_enlazada<Integer>();
		 Position<Integer> posicionEleml1 = null; Position<Integer> posicionEleml2 = null; 
		 Position<Integer> posMayor;
		 boolean esUltimoElementol1= false; boolean esUltimoElementol2 = false;
		 try {
			 if (l1.size() >= 1) posicionEleml1 = l1.first(); //Examina si las dos listas tienen al menos un elemento.
			 else esUltimoElementol1= true;
			 if (l2.size() >= 1) posicionEleml2 = l2.first();
			 else esUltimoElementol2 = false;
			 
			 while (!esUltimoElementol1 && !esUltimoElementol2) { //Controla que ninguna de las dos listas haya llegado al ultimo elemento
				 if (posicionEleml1.element()==posicionEleml2.element()) {     //Si los elementos son iguales, agrego el primero a la lista a retornar y controlo que
					toReturnLista.addFirst(posicionEleml1.element());   //ninguna de las dos listas haya llegado al ultimo elemento para poder obtener el siguiente
					esUltimoElementol1 = (!esUltimoElemento(l1, posicionEleml1.element()));
					if (!esUltimoElementol1) posicionEleml1 = l1.next(posicionEleml1);
					esUltimoElementol2 = (!esUltimoElemento(l2, posicionEleml2.element()));
					if (!esUltimoElementol2) posicionEleml2 = l2.next(posicionEleml2);
				}else {									//Si los elementos son distintos, obtengo el mayor y lo agrego a la lista a retornar
					posMayor = enteroMenor (posicionEleml1,posicionEleml2);
					toReturnLista.addFirst(posMayor.element());
					if (posMayor == posicionEleml1) {     //Si la posici�n agregada es la posici�n de la lista 1 y no es la ultima de la lista, cambio el valor
						if (!esUltimoElemento(l1,posicionEleml1.element())) posicionEleml1 = l1.next(posicionEleml1); //a la posici�n siguiente de la actual
						else esUltimoElementol1 = true;		 
					}else { //Si la pocisi�n agregada es la posici�n de la lista 2 y no es la ultima de la lista, cambio el valor de la posici�n a la previa de la actual
						if (!esUltimoElemento(l2,posicionEleml2.element())) posicionEleml2 = l2.next(posicionEleml2);
						else esUltimoElementol2 = true;
					}
				}
			 }	 
			//Como sali� del while anterior, una de las dos listas se debe haber quedado sin elementos para comparar,
			//o nunca entr� a dicho while y por lo tanto solo se ejecutar� lo siguiente si la lista a retornar tiene alg�n elemento
			while (!esUltimoElementol1) {  //Si la lista 2 se termin�, mientras la lista 1 no llegue a su ultimo elemento
				if (toReturnLista.isEmpty() || posicionEleml1.element()  != toReturnLista.first().element()) //y si la lista a retornar tiene elementos o si la posici�n no es la ultima de la lista a retornar,
					toReturnLista.addFirst(posicionEleml1.element() );										  // es decir,el elemento a agregar no es el mismo que el del principio de la lista, agrego el elemento
				if (!esUltimoElemento (l1, posicionEleml1.element())) { //Si la posici�n actual no corresponde al ultimo de la lista, pasa a valer la posici�n siguiente a la actual
					posicionEleml1 = l1.next(posicionEleml1);
				} else esUltimoElementol1 = true;  
			} 
			while (!esUltimoElementol2) { //Realiza las mismas acciones que el while anterior solo que se ejecuta si la lista 1 se termin�
				if (toReturnLista.isEmpty() || posicionEleml2.element() != toReturnLista.first().element())
					toReturnLista.addFirst(posicionEleml2.element());
				if (!esUltimoElemento (l1, posicionEleml2.element())) {
					posicionEleml2 = l2.next(posicionEleml2);
				} else esUltimoElementol2 = true; 
			}
		} catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {} 
	return toReturnLista;
}
	 
	 /**
	  * Se encarga de devolver la posici�n con el entero mayor entre dos posiciones
	  * @param n1 Posici�n n�mero 1
	  * @param n2 Posici�n n�mero 2
	  * @return Retorna la posici�n que contiene al entero mayor.
	  */
	 
	 private static Position<Integer> enteroMenor (Position<Integer> n1, Position<Integer> n2) {  
		 Position<Integer> toReturn;															 
		 int elemn1 = n1.element(); int elemn2 = n2.element();
		 if (elemn1 < elemn2) toReturn = n1;
		 else if (elemn2 < elemn1) toReturn = n2;
		 else toReturn = n1;
		 return toReturn;
	 }
	 
	 /**
	  * Examina si un elemento es el primero de la lista recibida por par�metro
	  * @param lista Lista en la que se examinar� si el elemento recibido por par�metro es el primero
	  * @param elemento Elemento que se decidir� si es el primero o no en la lista recibida por par�metro
	  * @return Retorna verdadero en caso de que el elemento recibido por par�metro sea el primero de la lista tambi�n recibida, devuelve 
	  * falso en caso contrario.
	  */
	 private static boolean esUltimoElemento (PositionList<Integer> lista, Integer elemento) { 
		 boolean toReturn = false;														
		 try {																			
			 toReturn = (elemento == lista.last().element());
		 } catch (EmptyListException e) {}
		 return toReturn;
	 }
}

