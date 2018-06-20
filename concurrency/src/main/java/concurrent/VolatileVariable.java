package concurrent;

public class VolatileVariable {

    public static void main(String[] args) throws InterruptedException {
        SharedObject sharedObject = new SharedObject();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000; i++) {
                    if (i % 55555 == 0) {
                        sharedObject.increment();
                        System.out.println("W" + sharedObject.count + "-" + sharedObject.volatileCount);

                    }
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000; i++) {
                    if (i % 100000 == 0) {
                        System.out.println("R:" + sharedObject.count + "-" + sharedObject.volatileCount);
                    }
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    private static class SharedObject {
        int volatileGuaranteedCount = 0;
        volatile int volatileCount = 0;
        int count = 0;

        void increment() {
            volatileGuaranteedCount++; // before volatile, update guaranteed
            volatileCount++;
            count++; // after volatile, instructions can be reordered by JVM
        }

    }
}


