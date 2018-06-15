package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class RolePresentationalData implements IRolePresentationalData {
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	
	public RolePresentationalData(
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
	) {
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		
	}

	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public RolePresentationalData withCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsRole() {
		return this.credentialsRole;
	}
	public void setCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
	}
	public RolePresentationalData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
}

/*       S.D.G.       */
