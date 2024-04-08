package uvg.edu.gt;

/**
 * Interfaz que define las operaciones básicas de una cola de prioridad
 * genérica.
 * 
 * @param <E> El tipo de elementos almacenados en la cola de prioridad.
 * 
 * @author Cristian Túnchez
 * @version 1.0
 * @since 08/04/2024
 */
public interface PriorityQueue<E> {

    /**
     * Verifica si la cola de prioridad está vacía.
     * 
     * @return true si la cola de prioridad está vacía, false de lo contrario.
     */
    public boolean isEmpty();

    /**
     * Elimina todos los elementos de la cola de prioridad.
     */
    public void clear();

    /**
     * Obtiene el número de elementos en la cola de prioridad.
     * 
     * @return El número de elementos en la cola de prioridad.
     */
    public int size();

    /**
     * Elimina y devuelve el elemento de mayor prioridad en la cola de prioridad.
     * 
     * @return El elemento de mayor prioridad en la cola de prioridad, o null si la
     *         cola está vacía.
     */
    public E poll();

    /**
     * Agrega un nuevo elemento a la cola de prioridad.
     * 
     * @param objeto El elemento que se va a agregar a la cola de prioridad.
     */
    public void add(E objeto);

    /**
     * Elimina y devuelve el elemento en la posición especificada de la cola de
     * prioridad.
     * 
     * @param i La posición del elemento que se va a eliminar.
     * @return El elemento en la posición especificada, o null si la posición es
     *         inválida.
     */
    public E remove(int i);
}