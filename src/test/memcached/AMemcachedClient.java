package test.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.BinaryConnectionFactory;
import net.spy.memcached.MemcachedClient;

public class AMemcachedClient {

	private static final int REQUEST_TIMEOUT = 900;

	private MemcachedClient memcachedClient;

	private static int EXPIRY_SECONDS = 2 * 86400; // 86400 sec = one day

	public AMemcachedClient() throws Exception {
		this("10.34.136.47:11211", EXPIRY_SECONDS);

	}

	public AMemcachedClient(String memcachedConnectionString, int expirySeconds) throws Exception {
		try {
			List<InetSocketAddress> srvAddresses = getSrvAddresses(memcachedConnectionString);
			memcachedClient = new MemcachedClient(new BinaryConnectionFactory(), srvAddresses);
			EXPIRY_SECONDS = expirySeconds;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<InetSocketAddress> getSrvAddresses(String memcachedConnectionString) throws Exception {
		List<InetSocketAddress> inetAddresses;
		try {
			inetAddresses = AddrUtil.getAddresses(memcachedConnectionString);
		} catch (Exception ee) {
			ee.printStackTrace();
			throw ee;
		}
		return inetAddresses;
	}

	public boolean add(String ip, String radiusAttributeContainer) {

		boolean result = false;
		Future<Boolean> f = memcachedClient.add(ip, EXPIRY_SECONDS, radiusAttributeContainer);
		try {

			result = f.get(REQUEST_TIMEOUT, TimeUnit.MILLISECONDS);
			if (result) {

			} else {

			}

		} catch (Exception eee) {
			eee.printStackTrace();
		}

		return result;
	}

	public String get(String ip) {

		String radiusAttributeContainer = null;
		Future<Object> future = memcachedClient.asyncGet(ip);
		try {
			radiusAttributeContainer = (String) future.get(REQUEST_TIMEOUT, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			future.cancel(false);
			e.printStackTrace();
		}
		if (radiusAttributeContainer != null) {

		} else {

		}

		return radiusAttributeContainer;
	}

	public void delete(String ip) {

		Future<Boolean> deletion = memcachedClient.delete(ip);
		try {
			Boolean result = deletion.get(REQUEST_TIMEOUT, TimeUnit.MILLISECONDS);
			if (result) {

			} else {

			}
		} catch (Exception eee) {
			eee.printStackTrace();
		}
	}

	public void close() {
		memcachedClient.shutdown();
	}

	protected void flush() {
		memcachedClient.flush();
		
	}

}
