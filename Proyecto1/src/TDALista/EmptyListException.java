package TDALista;

/**
 * Clase que modela la excepci�n arrojada por una lista vac�a
 * @author Selene
 */
public class EmptyListException extends Exception{
	/**
	 * Recibe el mensaje que se mostrar� al arrojar la excepci�n
	 * @param mensaje Mensaje que se mostrar� al momento de arrojar la excepci�n
	 */
    public EmptyListException(String mensaje) {
        super (mensaje);
    }
}
