package TDALista;
/**
 * Clase que modela la excepci�n arrojada si estamos ubicados en el �ltimo elemento de la lista y queremos obtener el siguiente
 * @author Selene
 */
public class BoundaryViolationException extends Exception {
	/**
	 * Recibe el mensaje que se mostrar� al arrojar la excepci�n
	 * @param mensaje Mensaje que se mostrar� al momento de arrojar la excepci�n
	 */
	public BoundaryViolationException(String mensaje) {
		super(mensaje);
	}
}