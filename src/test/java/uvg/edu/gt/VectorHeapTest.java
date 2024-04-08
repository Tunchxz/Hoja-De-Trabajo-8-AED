package uvg.edu.gt;

import static org.junit.Assert.*;
import org.junit.Test;

public class VectorHeapTest {

    @Test
    public void testAdd() {
        VectorHeap<Integer> heap = new VectorHeap<>();

        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);
        heap.add(10);

        assertEquals("[1, 3, 8, 5, 10]", heap.toString());
    }

    @Test
    public void testRemove() {
        VectorHeap<Integer> heap = new VectorHeap<>();

        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);
        heap.add(10);

        int output = heap.remove(2);

        assertEquals(8, output);
        assertEquals("[1, 3, 10, 5]", heap.toString());

        output = heap.poll();

        assertEquals(1, output);
        assertEquals("[3, 5, 10]", heap.toString());
    }
}