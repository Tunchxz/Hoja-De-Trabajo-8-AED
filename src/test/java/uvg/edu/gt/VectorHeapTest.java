package uvg.edu.gt;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Esta clase contiene pruebas unitarias para la clase VectorHeap.
 */
public class VectorHeapTest {

    /**
     * Prueba para el método add de la clase VectorHeap.
     * Agrega elementos al heap y verifica si se ordenan correctamente.
     */
    @Test
    public void testAdd() {
        VectorHeap<Integer> heap = new VectorHeap<>();

        // Agrega elementos al heap
        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);
        heap.add(10);

        // Verifica si los elementos se han ordenado correctamente en el heap
        assertEquals("[1, 3, 8, 5, 10]", heap.toString());
    }

    /**
     * Prueba para el método remove de la clase VectorHeap.
     * Elimina un elemento del heap y verifica si se realiza correctamente.
     */
    @Test
    public void testRemove() {
        VectorHeap<Integer> heap = new VectorHeap<>();

        // Agrega elementos al heap
        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);
        heap.add(10);

        // Remueve el elemento en la posición 2 del heap y verifica el resultado
        int output = heap.remove(2);
        assertEquals(8, output);
        assertEquals("[1, 3, 10, 5]", heap.toString());

        // Elimina y devuelve el elemento de mayor prioridad del heap y verifica el
        // resultado
        output = heap.poll();
        assertEquals(1, output);
        assertEquals("[3, 5, 10]", heap.toString());
    }
}