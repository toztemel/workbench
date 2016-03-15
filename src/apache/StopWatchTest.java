package apache;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;

public class StopWatchTest {

	@Test
	public void testStartStop() {
		StopWatch watch = new StopWatch();

		watch.start();
		sleep();
		System.out.println(watch.getTime());
		watch.stop();
		System.out.println(watch.getTime());
	}

	@Test
	public void testSuspendResume() {
		System.out.println();
		StopWatch watch = new StopWatch();

		watch.start();
		sleep();
		System.out.println(watch.getTime());

		watch.suspend();
		System.out.println(watch.getTime());
		sleep();
		watch.resume();
		System.out.println(watch.getTime());
		
		sleep();
		watch.stop();
		System.out.println(watch.getTime());
	}

	@Test
	public void testSplit() {
		System.out.println();

		StopWatch watch = new StopWatch();

		watch.start();
		sleep();
		System.out.println(watch.getTime());

		watch.split();
		System.out.println(watch.getTime());
		sleep();
		System.out.println(watch.getSplitTime());
		sleep();
		watch.unsplit();
		System.out.println(watch.getTime());
		
		sleep();
		watch.stop();
		System.out.println(watch.getTime());
	}

	private void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
