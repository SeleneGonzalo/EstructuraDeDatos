package TDAPila;

/**
 * Clase que implementa los métodos para una pila con arreglo
 * @author Selene
 * @param <E> Tipo de dato de los elementos a almacenar en la pila.
 */
public class Pila_arreglo <E> implements Stack<E>{
	private E datos[];
	private int tamaño;
	
	/**
	 * Se encarga de inicializar la cantidad de elementos de la pila y el valor
	 * máximo de elementos que tendrá el arreglo dentro de ésta
	 * @param maximo Valor máximo de elementos en el arreglo
	 */
	public Pila_arreglo(int maximo) {
		tamaño=0;
		datos = (E[]) new Object[maximo];
	}
	
	/**
	 * Constructor le da un valor máximo de elementos al arreglo
	 */
	public Pila_arreglo() {
		this(100);
	}
	
	@Override
	public int size() {
		return tamaño;
	}
	
	@Override
	public boolean isEmpty() {
		return tamaño==0;
	}
	
	@Override
	public E top() throws EmptyStackException{
		if (tamaño==0) throw new EmptyStackException("Pila vacía");
			return datos[tamaño-1];
	}
	
	@Override
	public void push (E elemento) {
		if (tamaño==datos.length) {
			resize();
			datos[tamaño++]=elemento;
		}else {
			datos[tamaño++]=elemento;
		}
	}
	
	@Override
	public E pop() throws EmptyStackException{
		if (tamaño==0){ throw new EmptyStackException("La pila está vacía");
		}else {
			E aux = datos[tamaño-1];
			datos[tamaño-1]=null;
			tamaño--;
			return aux;
		}
	}
	
	/**
	 * Se encarga de redimensionar el arreglo en la pila en caso de haberse llenado.
	 */
	private void resize() {
		E[] nuevo = (E[]) new Object [2*tamaño];
		for (int i=0; i<tamaño;i++)
			nuevo[i]=datos[i];
			datos=nuevo;
	}
	
}