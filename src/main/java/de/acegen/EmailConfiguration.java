package de.acegen;

public class EmailConfiguration {
	
	private String host;

	private int port;
	
	private String user;

	private String password;

	private String localhost;
	
	private boolean tls;
	
	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getLocalhost() {
		return localhost;
	}

	public boolean isTls() {
		return tls;
	}
	
}
