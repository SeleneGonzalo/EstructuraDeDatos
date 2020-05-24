package TDAPila;

/**
 * Clase que implementa los m�todos para una pila con arreglo
 * @author Selene
 * @param <E> Tipo de dato de los elementos a almacenar en la pila.
 */
public class Pila_arreglo <E> implements Stack<E>{
	private E datos[];
	private int tama�o;
	
	/**
	 * Se encarga de inicializar la cantidad de elementos de la pila y el valor
	 * m�ximo de elementos que tendr� el arreglo dentro de �sta
	 * @param maximo Valor m�ximo de elementos en el arreglo
	 */
	public Pila_arreglo(int maximo) {
		tama�o=0;
		datos = (E[]) new Object[maximo];
	}
	
	/**
	 * Constructor le da un valor m�ximo de elementos al arreglo
	 */
	public Pila_arreglo() {
		this(100);
	}
	
	@Override
	public int size() {
		return tama�o;
	}
	
	@Override
	public boolean isEmpty() {
		return tama�o==0;
	}
	
	@Override
	public E top() throws EmptyStackException{
		if (tama�o==0) throw new EmptyStackException("Pila vac�a");
			return datos[tama�o-1];
	}
	
	@Override
	public void push (E elemento) {
		if (tama�o==datos.length) {
			resize();
			datos[tama�o++]=elemento;
		}else {
			datos[tama�o++]=elemento;
		}
	}
	
	@Override
	public E pop() throws EmptyStackException{
		if (tama�o==0){ throw new EmptyStackException("La pila est� vac�a");
		}else {
			E aux = datos[tama�o-1];
			datos[tama�o-1]=null;
			tama�o--;
			return aux;
		}
	}
	
	/**
	 * Se encarga de redimensionar el arreglo en la pila en caso de haberse llenado.
	 */
	private void resize() {
		E[] nuevo = (E[]) new Object [2*tama�o];
		for (int i=0; i<tama�o;i++)
			nuevo[i]=datos[i];
			datos=nuevo;
	}
	
}