package concurrent.signaling;

public class BusyWaiting {

    private static class MySignal {

        private boolean hasData = false;

        synchronized boolean hasData() {
            return hasData;
        }

        synchronized void setData(boolean b) {
            hasData = b;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MySignal signal = new MySignal();

        Thread t1 = new Thread(() -> {
            while (!signal.hasData()) {
                System.out.println("wait for data");
            }
            System.out.println("process data");
        });

        Thread t2 = new Thread(() -> {
            for (int i = 12345; i < Integer.MAX_VALUE; i++) {
                if (i % 17 == 0) {
                    System.out.println("set flag");
                    signal.setData(true);
                    break;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
