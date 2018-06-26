package concurrent.semaphores;

public class BoundedSemaphore {

    private int signals = 0;
    private int bound = 0;

    BoundedSemaphore(int upperBound) {
        bound = upperBound;
    }

    // sends a signal
    synchronized void take() throws InterruptedException {
        while (signals == bound) {
            wait();
        }
        this.signals++;
        this.notify();
    }

    // waits for a signal. When receives, clears the signal.
    synchronized void release() throws InterruptedException {
        while (this.signals == 0) {
            wait();
        }
        this.signals--;
        this.notify();
    }
}
