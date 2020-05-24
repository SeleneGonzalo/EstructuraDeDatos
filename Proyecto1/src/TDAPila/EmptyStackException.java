package TDAPila;

/**
 * Clase que modela la excepción arrojada por una pila vacía
 * @author Selene
 */
public class EmptyStackException extends Exception{
	
	/**
	 * Recibe el mensaje que se mostrará al arrojar la excepción
	 * @param mensaje Mensaje que se mostrará al momento de arrojar la excepción
	 */
	public EmptyStackException (String mensaje){
		super(mensaje);
	}

}
