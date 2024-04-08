package uvg.edu.gt;

public interface PriorityQueue<E> {

    public boolean isEmpty();

    public void clear();

    public int size();

    public E poll();

    public void add(E objeto);

    public E remove(int i);
}
