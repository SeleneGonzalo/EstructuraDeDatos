package TDAPila;

/**
 * Clase que modela la excepci�n arrojada por una pila vac�a
 * @author Selene
 */
public class EmptyStackException extends Exception{
	
	/**
	 * Recibe el mensaje que se mostrar� al arrojar la excepci�n
	 * @param mensaje Mensaje que se mostrar� al momento de arrojar la excepci�n
	 */
	public EmptyStackException (String mensaje){
		super(mensaje);
	}

}
