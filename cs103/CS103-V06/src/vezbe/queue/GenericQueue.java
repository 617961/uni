package vezbe.queue;

public interface GenericQueue<E> {
    public boolean isEmpty();

    public int size();

    void enqueue(E elem);

    E front();

    E dequeue();
}
