package de.acegen;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailConfiguration {
	
	@NotEmpty
	@JsonProperty
	private String host;

	@JsonProperty
	private int port;
	
	@NotEmpty
	@JsonProperty
	private String user;

	@NotEmpty
	@JsonProperty
	private String password;

	@NotEmpty
	@JsonProperty
	private String localhost;
	
	@JsonProperty
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
