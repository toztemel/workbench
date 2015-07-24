package test.memcached;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AMemcachedClientLoadTest {

	private final static int threadCount = 10;
	private final static int sleep = 10;

	public static class Reading implements Runnable {
		AMemcachedClient A_MEMCACHED_CLIENT;

		public Reading(AMemcachedClient aMemcachedClient) {
			A_MEMCACHED_CLIENT = aMemcachedClient;
		}

		@Override
		public void run() {
			try {
				String key = getKey();
//				 System.out.println("get " + key);
				A_MEMCACHED_CLIENT.get(key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private static String getKey() {
		String key = String.valueOf((int) (Math.random() * 10000));
		return key;
	}

	public static class Writing implements Runnable {
		AMemcachedClient A_MEMCACHED_CLIENT;

		public Writing(AMemcachedClient aMemcachedClient) {
			A_MEMCACHED_CLIENT = aMemcachedClient;
		}

		@Override
		public void run() {
			try {
				String key = getKey();
//				 System.out.println("add " + key);
				A_MEMCACHED_CLIENT.add(key, String.valueOf(System.currentTimeMillis()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static class Cleaning implements Runnable {
		AMemcachedClient A_MEMCACHED_CLIENT;

		public Cleaning(AMemcachedClient aMemcachedClient) {
			A_MEMCACHED_CLIENT = aMemcachedClient;
		}

		@Override
		public void run() {
			try {
				String key = getKey();
//				 System.out.println("del " + key);
				A_MEMCACHED_CLIENT.delete(key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static class Writer implements Runnable {

		ExecutorService writers = Executors.newFixedThreadPool(threadCount);
		private AMemcachedClient aMemcachedClient;

		public Writer(AMemcachedClient aMemcachedClient) {
			this.aMemcachedClient = aMemcachedClient;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(sleep);
					writers.submit(new Writing(aMemcachedClient));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static class Readers implements Runnable {
		ExecutorService readers = Executors.newFixedThreadPool(threadCount);
		AMemcachedClient aMemcachedClient;

		public Readers(AMemcachedClient aMemcachedClient) {
			this.aMemcachedClient = aMemcachedClient;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(sleep);
					readers.submit(new Reading(aMemcachedClient));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static class Cleaners implements Runnable {
		ExecutorService cleaners = Executors.newFixedThreadPool(threadCount);
		AMemcachedClient aMemcachedClient;

		public Cleaners(AMemcachedClient aMemcachedClient) {
			this.aMemcachedClient = aMemcachedClient;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(sleep);
					cleaners.submit(new Cleaning(aMemcachedClient));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		try {
			ExecutorService service = Executors.newFixedThreadPool(3);
			service.submit(new Writer(new AMemcachedClient()));
			service.submit(new Cleaners(new AMemcachedClient()));
			service.submit(new Readers(new AMemcachedClient()));
			System.out.println("READY");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
