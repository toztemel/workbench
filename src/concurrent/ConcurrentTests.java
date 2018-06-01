package concurrent;

/**
 * Created by tayfuno on 06/04/16.
 */
public class ConcurrentTests {

    static class MyThread extends Thread {
        public MyThread(String s) {
            super(s);
        }

        @Override
        public void run() {
            System.out.println("Hello " + getName());
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread myThread = new MyThread("My Thread");
        myThread.start();
        System.out.println(Thread.currentThread().getName());

        Thread myThread2 = new Thread(new MyRunnable(), "My Runnable Thread");
        myThread2.start();
    }
}
