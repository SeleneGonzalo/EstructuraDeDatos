package TDALista;
/**
 * Clase que modela la excepción arrojada si estamos ubicados en el último elemento de la lista y queremos obtener el siguiente
 * @author Selene
 */
public class BoundaryViolationException extends Exception {
	/**
	 * Recibe el mensaje que se mostrará al arrojar la excepción
	 * @param mensaje Mensaje que se mostrará al momento de arrojar la excepción
	 */
	public BoundaryViolationException(String mensaje) {
		super(mensaje);
	}
}