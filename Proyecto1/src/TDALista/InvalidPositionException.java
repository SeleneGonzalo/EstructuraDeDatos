package TDALista;

/**
 * Clase que modela la excepci�n arrojada por una posici�n inv�lida
 * @author Selene
 */
public class InvalidPositionException extends Exception{
	/**
	 * Recibe el mensaje que se mostrar� al arrojar la excepci�n
	 * @param mensaje Mensaje que se mostrar� al momento de arrojar la excepci�n
	 */
    public InvalidPositionException (String mensaje) {
        super(mensaje);
    }
}
