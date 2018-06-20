package concurrent.signaling;

public class BoundedSemaphore {

    private int bound = 0;
    private int signals = 0;

    BoundedSemaphore(int upperBound) {
        bound = upperBound;
    }

    synchronized void take() throws InterruptedException {
        while (signals == bound) {
            wait();
        }
        signals++;
        notify();
    }

    synchronized void release() throws InterruptedException {
        while (signals == 0) {
            wait();
        }
        signals--;
        notify();
    }
}
