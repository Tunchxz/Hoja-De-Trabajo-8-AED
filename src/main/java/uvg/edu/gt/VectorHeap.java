package uvg.edu.gt;

import java.util.Vector;

/**
 * Implementación de una cola de prioridad utilizando un Vector como estructura
 * subyacente.
 * 
 * @param <E> El tipo de elementos almacenados en la cola de prioridad.
 * 
 * @author Cristian Túnchez
 * @version 1.0
 * @since 08/04/2024
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    // Vector que almacena los elementos de la cola de prioridad.
    private Vector<E> heap;

    /**
     * Constructor de la clase VectorHeap.
     * Inicializa el vector interno.
     */
    public VectorHeap() {
        heap = new Vector<>();
    }

    /**
     * Verifica si la cola de prioridad está vacía.
     * 
     * @return true si la cola de prioridad está vacía, false de lo contrario.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Elimina todos los elementos de la cola de prioridad.
     */
    @Override
    public void clear() {
        heap.clear();
    }

    /**
     * Obtiene el número de elementos en la cola de prioridad.
     * 
     * @return El número de elementos en la cola de prioridad.
     */
    @Override
    public int size() {
        return heap.size();
    }

    /**
     * Elimina y devuelve el elemento de mayor prioridad en la cola de prioridad.
     * 
     * @return El elemento de mayor prioridad en la cola de prioridad, o null si la
     *         cola está vacía.
     */
    @Override
    public E poll() {
        return remove(0);
    }

    /**
     * Agrega un nuevo elemento a la cola de prioridad.
     * 
     * @param objeto El elemento que se va a agregar a la cola de prioridad.
     */
    @Override
    public void add(E elem) {
        if (elem == null)
            throw new IllegalArgumentException();
        heap.add(elem);
        int indexOfLastElem = size() - 1;
        // Lleva el nuevo elemento hacia arriba en el heap para mantener la propiedad de
        // la cola de prioridad.
        swim(indexOfLastElem);
    }

    /**
     * Elimina y devuelve el elemento en la posición especificada de la cola de
     * prioridad.
     * 
     * @param i La posición del elemento que se va a eliminar.
     * @return El elemento en la posición especificada, o null si la posición es
     *         inválida.
     */
    @Override
    public E remove(int i) {
        if (isEmpty())
            return null;
        int indexOfLastElem = size() - 1;
        E removed_data = heap.get(i);
        // Intercambia el elemento a eliminar con el último elemento en el heap.
        swap(i, indexOfLastElem);
        // Elimina el último elemento del heap.
        heap.remove(indexOfLastElem);
        if (i == indexOfLastElem)
            return removed_data;
        E elem = heap.get(i);
        // Lleva el elemento hacia abajo en el heap para restaurar la propiedad de la
        // cola de prioridad.
        sink(i);
        if (heap.get(i).equals(elem))
            // Lleva el elemento hacia arriba en el heap si es necesario para mantener la
            // propiedad de la cola de prioridad.
            swim(i);
        return removed_data;
    }

    /**
     * Método que verifica si el elemento en la posición i es menor que el elemento
     * en la posición j.
     * 
     * @param i Índice del primer elemento.
     * @param j Índice del segundo elemento.
     * @return true si el elemento en la posición i es menor o igual que el elemento
     *         en la posición j, false de lo contrario.
     */
    private boolean less(int i, int j) {
        E node1 = heap.get(i);
        E node2 = heap.get(j);
        return node1.compareTo(node2) <= 0;
    }

    /**
     * Método para llevar un elemento hacia arriba en el heap.
     * 
     * @param k Índice del elemento a subir.
     */
    private void swim(int k) {
        int parent = (k - 1) / 2;
        while (k > 0 && less(k, parent)) {
            // Intercambia el elemento actual con su padre si es necesario.
            swap(parent, k);
            k = parent;
            parent = (k - 1) / 2;
        }
    }

    /**
     * Método para llevar un elemento hacia abajo en el heap.
     * 
     * @param k Índice del elemento a hundir.
     */
    private void sink(int k) {
        int heapSize = size();
        while (true) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int smallest = left;
            if (right < heapSize && less(right, left))
                smallest = right;
            if (left >= heapSize || less(k, smallest))
                break;
            // Intercambia el elemento actual con su hijo más pequeño si es necesario.
            swap(smallest, k);
            k = smallest;
        }
    }

    /**
     * Método para intercambiar dos elementos en el heap.
     * 
     * @param i Índice del primer elemento.
     * @param j Índice del segundo elemento.
     */
    private void swap(int i, int j) {
        E elem_i = heap.get(i);
        E elem_j = heap.get(j);
        // Reemplaza el elemento en la posición i con el elemento en la posición j.
        heap.set(i, elem_j);
        // Reemplaza el elemento en la posición j con el elemento en la posición i.
        heap.set(j, elem_i);
    }

    /**
     * Método getter para obtener el vector interno que almacena los elementos del
     * heap.
     * 
     * @return El vector que representa el heap.
     */
    public Vector<E> getHeap() {
        return heap;
    }

    /**
     * Método que devuelve la cola de prioridad (sus elementos) como una cadena.
     * 
     * @return La cola y todos sus elementos e forma de una cadena.
     */
    @Override
    public String toString() {
        return heap.toString();
    }
}