package TDALista;

/**
 * Clase que modela la excepción arrojada por una lista vacía
 * @author Selene
 */
public class EmptyListException extends Exception{
	/**
	 * Recibe el mensaje que se mostrará al arrojar la excepción
	 * @param mensaje Mensaje que se mostrará al momento de arrojar la excepción
	 */
    public EmptyListException(String mensaje) {
        super (mensaje);
    }
}
