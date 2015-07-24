package test.memcached;

import static org.junit.Assert.*;

import java.util.concurrent.BlockingQueue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AMemcachedClientTest {

	private static AMemcachedClient client;

	@BeforeClass
	public static void init() throws Exception {
		client = new AMemcachedClient("10.34.136.47:11211", 1200);
	}

	@AfterClass
	public static void terminate() {
		client.close();
	}

	@Test
	public void testAdd() {
		client.add("key", "value");
		assertEquals("value", client.get("key"));
	}

	@Test
	public void testDelete() {
		client.add("key1", "value1");
		assertEquals("value1", client.get("key1"));
		client.delete("key1");
		assertNull(client.get("key1"));
	}

	@Test
	public void testSet() {
	}

	@Test
	public void testFlush() {
		client.flush();
	}
}
