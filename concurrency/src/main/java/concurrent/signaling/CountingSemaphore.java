package concurrent.signaling;

public class CountingSemaphore {

    private int signals = 0;

    synchronized void take() {
        signals++;
        notify();
    }

    synchronized void release() throws InterruptedException {
        while (signals == 0) {
            wait();
        }
        signals--;
    }
}
