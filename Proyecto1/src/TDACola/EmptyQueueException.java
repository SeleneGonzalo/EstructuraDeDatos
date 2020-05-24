package TDACola;
/**
 * Clase que modela la excepción arrojada por una cola vacía
 * @author Selene
 */
public class EmptyQueueException extends Exception{
	/**
	 * Recibe el mensaje que se mostrará al arrojar la excepción
	 * @param mensaje Mensaje que se mostrará al momento de arrojar la excepción
	 */
	EmptyQueueException (String mensaje){
		super(mensaje);
	}
}
