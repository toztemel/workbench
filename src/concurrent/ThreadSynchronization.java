package concurrent;

public class ThreadSynchronization {

    private static int COUNT = 2000000;

    private static class Counter {
        int value;

        synchronized void increment() {
            value++;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            runExperiment();
        }
    }

    private static void runExperiment() {
        try {

            long start = System.currentTimeMillis();
            experimentSharedData();
            long duration1 = System.currentTimeMillis() - start;

            start = System.currentTimeMillis();
            experimentNonSharedData();
            long duration2 = System.currentTimeMillis() - start;

            System.out.println("duration1:" + duration1 + " duration2:" + duration2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void experimentSharedData() throws InterruptedException {
        Counter counter = new Counter();
        Runnable r = () -> {
            for (int i = 0; i < COUNT; i++) {
                counter.increment();
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    private static void experimentNonSharedData() throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                counter1.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                counter2.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
