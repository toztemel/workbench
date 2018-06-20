package concurrent.signaling;

import java.util.stream.IntStream;

public class Semaphore {

    private boolean signal = false;

    synchronized void take() {
        this.signal = true;
        this.notify();
    }

    synchronized void release() throws InterruptedException {
        while (!this.signal) {
            wait();
        }
        this.signal = false;
    }

    public static void main(String[] args) {
        Semaphore s = new Semaphore();

        Thread sender = new Thread() {
            @Override
            public void run() {
                while (true) {
                    for (int i = 0; i < 1000000; i++) {
                        if (i % 13 == 0) {
                            s.take();
                        }
                    }
                }
            }
        };

        Thread receiver = new Thread() {
            int count = 0;
            @Override
            public void run() {
                while (true) {
                    try {
                        s.release();
                        count++;
                        if (count % 10==0) {
                            System.out.println(count);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        sender.start();
        receiver.start();
    }
}
