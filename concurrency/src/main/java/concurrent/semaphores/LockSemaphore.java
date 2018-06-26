package concurrent.semaphores;

import java.util.Arrays;

public class LockSemaphore {

    public static void main(String[] args) throws InterruptedException {

        BoundedSemaphore semaphore = new BoundedSemaphore(1);

        Thread[] pool = new Thread[10];
        for (int i = 0; i < pool.length; i++) {
            pool[i] = new Thread(() -> {
                try {


                    semaphore.take();
                    try {
                        // critical section
                    } finally {
                        semaphore.release();
                    }


                } catch (InterruptedException ignore) {}
            });
        }
        Arrays.stream(pool).forEach(t -> t.start());
    }

}
