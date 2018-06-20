package concurrent.signaling;

// ReadWriteLock is not reentrant
// i.e. if a thread calls lockRead() more than one time, enters a DeadLock
public class ReadWriteLock {

    private int readers = 0;
    private int writers = 0;
    private int writeRequests = 0;

    synchronized void lockRead() throws InterruptedException {
        while (writeRequests > 0 || writers > 0) {
            wait();
        }
        readers++;
    }

    synchronized void unlockRead() {
        readers--;
        notifyAll();
    }

    synchronized void lockWrite() throws InterruptedException {
        writeRequests++;

        while (readers > 0 || writers > 0) {
            wait();
        }

        writeRequests--;
        writers++;
    }

    synchronized void unlockWrite() {
        writers--;
        notifyAll();
    }
}
