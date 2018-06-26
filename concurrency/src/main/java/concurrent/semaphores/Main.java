package concurrent.semaphores;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.run();
    }

    private void run() {
        Semaphore semaphore = new Semaphore();
        CountingSemaphore countingSemaphore = new CountingSemaphore();

        Thread sender = new Thread(() -> {
            while (true) {
                semaphore.take();
                countingSemaphore.take();
            }
        });
        Thread receiver = new Thread(() -> {
            while (true) {
                try {
                    semaphore.release();
                    countingSemaphore.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        sender.start();
        receiver.start();

    }

}
