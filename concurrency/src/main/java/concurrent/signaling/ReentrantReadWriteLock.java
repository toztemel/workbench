package concurrent.signaling;

import java.util.HashMap;
import java.util.Map;

// ReadWriteLock is not reentrant
// i.e. if a thread calls lockRead() more than one time, enters a DeadLock
public class ReentrantReadWriteLock {

    private Map<Thread, Integer> readingThreads = new HashMap<>();
    private int writerAccesses = 0;
    private int writeRequests = 0;
    private Thread writingThread = null;

    synchronized void lockRead() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        while (!canGrantReadAccess(callingThread)) {
            wait();
        }

        readingThreads.put(callingThread, (getAccessCount(callingThread) + 1));
    }

    private int getAccessCount(Thread callingThread) {
        Integer accessCount = readingThreads.get(callingThread);
        if (accessCount == null) {
            return 0;
        }
        return accessCount.intValue();
    }

    private boolean canGrantReadAccess(Thread callingThread) {
        if(isWriter(callingThread)) return true;
        if (writerAccesses > 0) return false;
        if (isReader(callingThread)) return true;
        if (writeRequests > 0) return false;
        return true;

    }

    private boolean isReader(Thread callingThread) {
        return readingThreads.get(callingThread) != null;
    }

    synchronized void unlockRead() {
        Thread callingThread = Thread.currentThread();
        if (!isReader(callingThread)){
            throw new IllegalMonitorStateException("Calling thread does not have read lock");
        }
        int accessCount = getAccessCount(callingThread);
        if (accessCount == 1) {
            readingThreads.remove(callingThread);
        } else {
            readingThreads.put(callingThread, accessCount - 1);
        }
        notifyAll();
    }

    synchronized void lockWrite() throws InterruptedException {
        writeRequests++;

        Thread callingThread = Thread.currentThread();
        while (!canGrantWriteAccess(callingThread)) {
            wait();
        }

        writeRequests--;
        writerAccesses++;
        writingThread = callingThread;
    }

    private boolean canGrantWriteAccess(Thread callingThread) {
        if (isOnlyReader(callingThread)) {
            return true;
        }
        if (hasReaders()) {
            return false;
        }
        if (writingThread == null) {
            return true;
        }
        if (!isWriter(callingThread)) {
            return false;
        }
        return true;
    }

    private boolean isOnlyReader(Thread callingThread) {
        return readingThreads.size() == 1 &&
                readingThreads.get(callingThread) != null;
    }

    private boolean isWriter(Thread callingThread) {
        return writingThread == callingThread;
    }

    private boolean hasReaders() {
        return readingThreads.size() > 0;
    }

    synchronized void unlockWrite() {
        writerAccesses--;
        if (writerAccesses == 0) {
            writingThread = null;
        }
        notifyAll();
    }
}
