package concurrent;

public class Threads {

    public static void main(String[] args) {
        Thread t = new Thread("cirak"){
            @Override
            public void run() {
                System.out.println("Hello " + getName());
            }
        };
        t.start();

        Thread r = new Thread(new MyRunnable());
        r.start();

        Runnable ru = () -> System.out.println("Runnable inner class");
        Thread r2 = new Thread(ru);
        r2.start();

        for (int i = 0; i < 10; i++) {
            new Thread("MyThread"+i){
                @Override
                public void run() {
                    System.out.println("Thread:"+getName()+" is running");
                }
            }.start();
        }
    }

    private static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("Runnable runs");
        }
    }
}
