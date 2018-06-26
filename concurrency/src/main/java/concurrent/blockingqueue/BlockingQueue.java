package concurrent.blockingqueue;

import java.util.LinkedList;
import java.util.List;

/**
 * Notice how notifyAll() is only called from enqueue() and dequeue()
 * if the queue size is equal to the size bounds (0 or limit). If the
 * queue size is not equal to either bound when enqueue() or dequeue()
 * is called, there can be no threads waiting to either enqueue or
 * dequeue items
 */
public class BlockingQueue {

    private List<Object> queue = new LinkedList<>();
    private int limit = 10;

    public BlockingQueue(int l) {
        limit = l;
    }

    public synchronized void enqueue(Object item) throws InterruptedException {
        while (queue.size() == limit) {
            wait();
        }
        if (queue.size() == 0) {
            notifyAll();
        }
        queue.add(item);
    }

    public synchronized Object dequeue() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }

        if (queue.size() == limit) {
            notifyAll();
        }

        return queue.remove(0);
    }
}
