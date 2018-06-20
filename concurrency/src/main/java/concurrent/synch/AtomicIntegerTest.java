package synch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	public class Task implements Runnable {

		@Override
		public void run() {
			nonatomic++;
			atomic.incrementAndGet();
		}

	}

	private int nonatomic = 0;
	private AtomicInteger atomic = new AtomicInteger(0);

	public static void main(String[] args) {
		AtomicIntegerTest test = new AtomicIntegerTest();
		test.execute();
	}

	private void execute() {
		ExecutorService service = Executors.newFixedThreadPool(100);
		for (int i = 0; i < 10000; i++) {
			service.execute(new Task());
		}
		System.out.println("submitted jobs");
		service.shutdown();
		try {
			service.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\nnonatomic:" + nonatomic);
		System.out.println("atomic:" + atomic.get());
	}
}
