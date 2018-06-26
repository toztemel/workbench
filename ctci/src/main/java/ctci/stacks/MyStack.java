package ctci.stacks;

import java.util.EmptyStackException;

/**
 * LIFO
 *
 * Useful for
 *  recursion algorithms
 *  iterative algoritms
 */
public class MyStack<T> {

    private StackNode<T> top;

    T pop() {
        if (top == null) {
            throwEmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    private T throwEmptyStackException() {
        throw new EmptyStackException();
    }

    void push(T t) {
        StackNode<T> node = new StackNode<>(t);
        node.next = top;
        top = node;
    }

    T peek() {
        if (null == top) {
            throwEmptyStackException();
        }
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        StackNode(T data) {
            this.data = data;
        }
    }
}
