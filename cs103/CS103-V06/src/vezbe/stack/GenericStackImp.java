package vezbe.stack;

import vezbe.stack.GenericStack;

import java.util.ArrayList;

public class GenericStackImp<E> implements GenericStack<E> {
    private int initialCapacity = 32;
    private ArrayList<E> data = new ArrayList<>();
    int top = -1;

    public GenericStackImp() {
    }

    public GenericStackImp(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }


    @Override
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    @Override
    public int capacity() {
        return this.initialCapacity;
    }

    @Override
    public boolean resize() {
        return false;
    }

    @Override
    public void push(E elem) {
        if (top >= initialCapacity) {
            System.err.println("Stack overflow error!");
            return;
        }
        data.add(++top, elem);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            System.err.println("Stack underflow error!");
        }
        return data.get(top);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            System.err.println("Stack underflow error!");
        }
        return data.get(top--);
    }
}
