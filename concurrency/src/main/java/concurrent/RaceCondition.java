package concurrent;

import java.util.Arrays;

public class RaceCondition {

    private static class Counter {

        long count = 0;
        long syncCount = 0;

        void add(long v) {

            this.count = this.count + v;

            synchronized (this) {
                syncCount = syncCount + v;
            }

        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            experiment();
        }
    }

    private static void experiment() {

        Counter c = new Counter();
        Runnable r = () -> {
            for (int j = 0; j < 1000; j++) {
                c.add(1);
            }
        };

        concurrentIncrement(r);

        System.out.println(c.count + " - " + c.syncCount);
    }

    private static void concurrentIncrement(Runnable r) {

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(r);
        }

        Arrays.stream(threads).parallel().forEach(Thread::start);

        Arrays.stream(threads).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
