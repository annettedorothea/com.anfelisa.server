package de.acegen;

public class YamlConfiguration {
	
	private Database database;
	
	private Server server;
	
	private String secretString;

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public String getSecretString() {
		return secretString;
	}
	
	
}
