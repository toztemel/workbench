package ctci.queues;

import java.util.NoSuchElementException;

/**
 * FIFO
 * <p>
 * Useful for
 * <li>
 * breadth-first search
 * cache implementation
 * </li>
 */
public class MyQueue<T> {

    QueueNode<T> first;
    QueueNode<T> last;

    void add(T item) {
        QueueNode<T> newNode = new QueueNode<>(item);

        if (first == null) {
            first = newNode;
        }

        if (last != null) {
            last.next = newNode;
        }
        last = newNode;
    }

    T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T data = first.data;

        first = first.next;
        if (first == null) {
            last = null;
        }

        return data;
    }

    T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    boolean isEmpty() {
        return first == null;
    }

    private static class QueueNode<T> {
        T data;
        QueueNode<T> next;

        QueueNode(T data) {
            this.data = data;
        }
    }
}
