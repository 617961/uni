package vezbe.queue;

import java.util.LinkedList;

public class GenericQueueImp<E> implements GenericQueue<E> {

    private LinkedList<E> data = new LinkedList<>();
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return size == 0 || size < -1;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public void enqueue(E elem) {
        data.addLast(elem);
        size++;
    }

    @Override
    public E front() {
        if (size > 0) {
            return data.getFirst();
        } else {
            System.err.println("Queue underflow error!");
            return null;
        }
    }

    @Override
    public E dequeue() {
        if(size <= 0){
            System.err.println("Queue underflow error!");
            return null;
        }
        size--;
        return data.removeFirst();
    }

}
