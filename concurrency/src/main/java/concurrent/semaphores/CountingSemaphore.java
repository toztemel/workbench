package concurrent.semaphores;

public class CountingSemaphore {

    private int signals = 0;

    // sends a signal
    synchronized void take() {
        this.signals++;
        this.notify();
    }

    // waits for a signal. When receives, clears the signal.
    synchronized void release() throws InterruptedException {
        while (this.signals != 0) {
            wait();
        }
        this.signals--;
    }

}
