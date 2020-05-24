package TDACola;
/**
 * Clase que modela la excepci�n arrojada por una cola vac�a
 * @author Selene
 */
public class EmptyQueueException extends Exception{
	/**
	 * Recibe el mensaje que se mostrar� al arrojar la excepci�n
	 * @param mensaje Mensaje que se mostrar� al momento de arrojar la excepci�n
	 */
	EmptyQueueException (String mensaje){
		super(mensaje);
	}
}
