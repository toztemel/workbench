package query.zgrep.remote;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.net.bsd.RExecClient;

import query.Address;
import query.EdrString;
import query.MessageId;
import query.MessagingError;
import query.SearchEngine;
import query.SmscEdrResultSet;

public class ZGrepRemoteSearchEngine implements SearchEngine {

	private ThreadPoolExecutor threadPoolExecutor;
	private List<RemoteEntity> remoteHosts;

	public ZGrepRemoteSearchEngine() {
		initializeThreadPool();
		initializeRemoteHostList();
	}

	private void initializeRemoteHostList() {
		remoteHosts = new ArrayList<RemoteEntity>();
		for (int i = 0 ; i< 1 ; i++ ) {
			RemoteEntityConnectionInfo connection = new RemoteEntityConnectionInfo();
			connection.setHostIp("10.34.37.12" + i);
			connection.setUser("root");
			connection.setPassword("tneu34");
			remoteHosts.add(new RemoteEntity("/space", connection));
		}
		System.out.println("Remote hosts initialized");
	}

	private void initializeThreadPool() {
		int corePoolSize = 1;
		int maximumPoolSize = 2;
		long keepAliveTime = 500;
		TimeUnit unit = TimeUnit.SECONDS;
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(10) ;
		threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,
				maximumPoolSize, keepAliveTime, unit, workQueue);

		System.out.println("threadpool initialized");
	}

	@Override
	public SmscEdrResultSet searchEdrWithMessageId(MessageId messageId) {
		SmscEdrResultSet resultSet = new SmscEdrResultSet();
		SearchQuery query = new MessageIdQuery(messageId);
		searchRemoteHosts(query, resultSet);
		return resultSet;
	}

	private void searchRemoteHosts(SearchQuery query, SmscEdrResultSet resultSet) {
		for (RemoteEntity entity : remoteHosts) {
			searchRemoteHost(entity, query, resultSet);
		}
		awaitTermination();
	}

	private void awaitTermination() {
		try {
			this.threadPoolExecutor.awaitTermination(1L, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void searchRemoteHost(RemoteEntity entity, SearchQuery query, SmscEdrResultSet resultSet) {
		SearchTask task = new SearchTask(entity,query, resultSet);
		this.threadPoolExecutor.execute(task);
	}

	@Override
	public SmscEdrResultSet searchEdrWithSingleAddress(Address anAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SmscEdrResultSet searchEdrWithABParties(Address aParty,
			Address bParty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SmscEdrResultSet searchEdrWithErrorCode(
			MessagingError parameterObject) {
		return null;
	}

	class SearchTask implements Runnable {
		private RemoteEntity searchTarget;
		private SmscEdrResultSet resultSet;
		private final SearchQuery query;

		public SearchTask(RemoteEntity entity, SearchQuery query, SmscEdrResultSet container) {
			this.searchTarget = entity;
			this.query = query;
			this.resultSet = container;
		}

		@Override
		public void run() {
			System.out.println("Executed grep command in " + searchTarget.getConnectionInfo().getHostIp());
			
			RExecClient client = new RExecClient();
			try {
				String server = searchTarget.getConnectionInfo().getHostIp();
				client.connect(server,22);
			} catch (IOException e) {
				e.printStackTrace();
			}

			String username = "root";
			String password = "tneu34";
			String command = "zgrep -e \"-001463807644:11df416:13bacbd402b:-7735\" /space/SMSC*.zip";
//			String username = searchTarget.getConnectionInfo().getUser();
//			String password = searchTarget.getConnectionInfo().getPassword();
//			String command = query.getCommand();
			try {
				client.rexec(username, password, command);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			IOUtil.readWrite(client.getInputStream(), client.getOutputStream(),
					System.in, System.out);

			try {
				client.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			EdrString sResult = new EdrString(",20121218084108,2,3,1542821307,,1542821307,905074955721,905543264788,113,0,0,0,0,-001463807644:11df416:13bacbd402b:-7735,0,,0,0,20121218084100,,286032400284461,,905590101003,,905590101003,,,1,,,,,1,,,E001,");
			addToResults( sResult);
		}

		private void addToResults(EdrString sResult) {
			resultSet.addEdrString(sResult);
		}

	}
	
	public static void main(String[] args) {
		ZGrepRemoteSearchEngine engine = new ZGrepRemoteSearchEngine();
		SmscEdrResultSet results = engine.searchEdrWithMessageId(new MessageId("abcdMessageId"));
		System.out.println("Result size : " + results.size());
	}

}
