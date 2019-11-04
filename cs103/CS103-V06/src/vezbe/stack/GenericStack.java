package vezbe.stack;

public interface GenericStack<E> {
    public boolean isEmpty();

    public int capacity();

    boolean resize();

    void push(E elem);

    E peek();

    E pop();
}
