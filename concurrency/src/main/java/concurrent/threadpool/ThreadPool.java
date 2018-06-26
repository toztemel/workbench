package concurrent.threadpool;

import concurrent.blockingqueue.BlockingQueue;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

    private BlockingQueue taskQueue = null;
    private List<PoolThread> threads = new ArrayList<>();
    private boolean isStopped = false;

    ThreadPool(int threadCount, int tasks) {
        taskQueue = new BlockingQueue(tasks);
        for (int i = 0; i < threadCount; i++) {
            threads.add(new PoolThread(taskQueue));
        }
        threads.forEach(t -> t.start());
    }

    public synchronized void execute(Runnable task) throws InterruptedException {
        if (isStopped) {
            throw new IllegalStateException("pool is stopped");
        }
        taskQueue.enqueue(task);
    }

    public synchronized void stop() {
        isStopped = true;
        threads.forEach(t -> t.doStop());
    }

    private class PoolThread extends Thread {

        private final BlockingQueue taskQueue;
        private boolean isStopped = false;

        public PoolThread(BlockingQueue taskQueue) {
            this.taskQueue = taskQueue;
        }

        @Override
        public void run() {
            while (!isStopped) {
                try {
                    Runnable runnable = (Runnable) taskQueue.dequeue();
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void doStop() {
            isStopped = true;
            this.interrupt(); // break thread out of dequeue call
        }

        public synchronized boolean isStopped() {
            return isStopped;
        }
    }
}
