package grep.query.zgrep.remote;

public class RemoteEntity {
	private String searchDirectory;
	private RemoteEntityConnectionInfo connectionInfo;

	public RemoteEntity(String directory, RemoteEntityConnectionInfo connection) {
		this.searchDirectory = directory;
		connectionInfo = connection;
		
	}

	public String getSearchDirectory() {
		return searchDirectory;
	}

	public void setSearchDirectory(String searchDirectory) {
		this.searchDirectory = searchDirectory;
	}

	public RemoteEntityConnectionInfo getConnectionInfo() {
		return connectionInfo;
	}

	public void setConnectionInfo(RemoteEntityConnectionInfo connectionInfo) {
		this.connectionInfo = connectionInfo;
	}


}