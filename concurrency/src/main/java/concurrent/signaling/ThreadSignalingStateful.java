package concurrent.signaling;

public class ThreadSignalingStateful {

    private static class MonitorObject {

    }

    // WaitNotify does not misses signals
    private static class WaitNotify {
        MonitorObject monitorObject = new MonitorObject();
        boolean isNotified = false;

        void doWait() {
            synchronized (monitorObject) {
                if(!isNotified) {
                    try {
                        monitorObject.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                isNotified = false;
            }
        }

        void doNotify() {
            synchronized (monitorObject) {
                isNotified = true;
                monitorObject.notify();
            }
        }

        void doNotifyAll() {
            synchronized (monitorObject) {
                monitorObject.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitNotify wn = new WaitNotify();
        WaitNotify wn2 = new WaitNotify();

        Thread t1 = new Thread(() -> {
            System.out.println("T1: running");
            System.out.println("T1: wait on monitor");

            wn.doWait();
            System.out.println("T1: monitor notified");

            try {
                Thread.sleep(2000);
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T1: notify monitor2");
            wn2.doNotify();

            System.out.println("T1: wait on monitor");
            wn.doWait();

            System.out.println("T1: monitor notified");
            System.out.println("T1: exit");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("T2: running");
            System.out.println("T2: wait on monitor");
            wn.doWait();
            System.out.println("T2: monitor notified");
            System.out.println("T2: exit");
        });

        Thread t3 = new Thread(() -> {
            System.out.println("T3: running");
            System.out.println("T3: sleeping");
            try {
                Thread.sleep(2000);
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T3: wake up");

            System.out.println("T3: notify monitor");
            wn.doNotify();

            System.out.println("T3: wait on monitor2");
            wn2.doWait();
            System.out.println("T3: monitor2 notified ");

            System.out.println("T3: notiyfAll monitor ");
            wn.doNotifyAll();

            System.out.println("T3: exit");
        });

        t1.start();
        t2.start();
        t3.start();

        t3.join();
        t2.join();
        t1.join();
    }
}
