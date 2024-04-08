package uvg.edu.gt;

import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private Vector<E> heap;

    public VectorHeap() {
        heap = new Vector<>();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        heap.clear();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public E poll() {
        return remove(0);
    }

    @Override
    public void add(E elem) {
        if (elem == null)
            throw new IllegalArgumentException();
        heap.add(elem);
        int indexOfLastElem = size() - 1;
        swim(indexOfLastElem);
    }

    @Override
    public E remove(int i) {
        if (isEmpty())
            return null;
        int indexOfLastElem = size() - 1;
        E removed_data = heap.get(i);
        swap(i, indexOfLastElem);
        heap.remove(indexOfLastElem);
        if (i == indexOfLastElem)
            return removed_data;
        E elem = heap.get(i);
        sink(i);
        if (heap.get(i).equals(elem))
            swim(i);
        return removed_data;
    }

    private boolean less(int i, int j) {
        E node1 = heap.get(i);
        E node2 = heap.get(j);
        return node1.compareTo(node2) <= 0;
    }

    private void swim(int k) {
        int parent = (k - 1) / 2;
        while (k > 0 && less(k, parent)) {
            swap(parent, k);
            k = parent;
            parent = (k - 1) / 2;
        }
    }

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
            swap(smallest, k);
            k = smallest;
        }
    }

    private void swap(int i, int j) {
        E elem_i = heap.get(i);
        E elem_j = heap.get(j);
        heap.set(i, elem_j);
        heap.set(j, elem_i);
    }

    public Vector<E> getHeap() {
        return heap;
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}