package concurrent.semaphores;

public class Semaphore {
    private boolean signal = false;

    // sends a signal
    synchronized void take() {
        this.signal = true;
        this.notify();
    }

    // waits for a signal. When receives, clears the signal.
    synchronized void release() throws InterruptedException {
        while (!this.signal) {
            wait();
        }
        this.signal = false;
    }
}
