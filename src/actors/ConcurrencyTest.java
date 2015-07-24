package actors;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Before;
import org.junit.Test;

public class ConcurrencyTest {

	class AsyncCounter {
		private int count = 0;

		public int increment() {
			return ++count;
		}
	}
	
	class SyncCounter {
		private int scount = 0;

		public synchronized int increment() {
			return ++scount;
		}
	}

	AsyncCounter asyncCounter = new AsyncCounter();
	SyncCounter syncCounter = new SyncCounter();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ExecutorService threadPool = Executors.newFixedThreadPool(100);
		StopWatch watch = new StopWatch();
		watch.start();
		System.out.println("Started");
		
		for (int i = 0; i < Integer.MAX_VALUE / 100; i++) {
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					asyncCounter.increment();
				}
			});
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					syncCounter.increment();
				}
			});
		}
		System.out.println("Assigned tasks:" + watch.getTime());

		try {
			threadPool.shutdown();
			threadPool.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed tasks:" + watch.getTime());
		
		assertNotEquals(Integer.MAX_VALUE / 100, asyncCounter.count);
		assertEquals(Integer.MAX_VALUE / 100, syncCounter.scount);
	}

}
