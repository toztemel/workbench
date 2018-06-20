package concurrent;

public class ThreadLocalExample {

    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> new Integer(0));
        // can be used by sub-threads
        private InheritableThreadLocal<Integer> globalThreadLocal = new InheritableThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return (int) (Math.random() * 100D);
            }
        };

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread().getName()+ " threadLocal = "+threadLocal.get() + ", global = " + globalThreadLocal.get());
        }

        Integer getValue() {
            return threadLocal.get();
        }

        Integer getInheritableValue() {
            return globalThreadLocal.get();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable r = new MyRunnable();
        System.out.println(Thread.currentThread().getName() + " threadLocal.value = " + r.getValue());
        System.out.println(Thread.currentThread().getName() + " inheritable threadlocal.value = " + r.getInheritableValue());

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

}
