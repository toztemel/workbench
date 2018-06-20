package concurrent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConsumerProducer {

    private static final Queue<Integer> queue = new ConcurrentLinkedQueue<Integer>();

    private static final long startMillis = System.currentTimeMillis();

    public static class Consumer implements Runnable {

        @Override
        public void run() {
            //while(System.currentTimeMillis() < startMillis + 10000) {
            while(true) {
                synchronized (queue) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!queue.isEmpty()) {
                    Integer integer = queue.poll();
                    System.out.println("[" + Thread.currentThread().getName() + "]:" + integer);
                }
            }
        }
    }

    public static class Producer implements Runnable {


        @Override
        public void run() {
            int i = 0;
            //while (System.currentTimeMillis() < startMillis + 10000) {
            while (i < Integer.MAX_VALUE) {
                queue.add(i++);
                System.out.println("produced:"+i);
                synchronized (queue) {
                    queue.notify();
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (queue) {
                queue.notifyAll();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread[] consumers = new Thread[5];
        for (int i = 0; i < 5; i++) {
            consumers[i] = new Thread(new Consumer(), "consumer-"+i);
            consumers[i].start();
        }

        Thread producerThread = new Thread(new Producer(), "producer");
        producerThread.start();

        for (int i = 0; i < 5; i++) {
            consumers[i].join();
        }
        producerThread.join();
    }
}
