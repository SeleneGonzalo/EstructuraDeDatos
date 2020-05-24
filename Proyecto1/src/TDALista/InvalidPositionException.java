package TDALista;

/**
 * Clase que modela la excepción arrojada por una posición inválida
 * @author Selene
 */
public class InvalidPositionException extends Exception{
	/**
	 * Recibe el mensaje que se mostrará al arrojar la excepción
	 * @param mensaje Mensaje que se mostrará al momento de arrojar la excepción
	 */
    public InvalidPositionException (String mensaje) {
        super(mensaje);
    }
}
