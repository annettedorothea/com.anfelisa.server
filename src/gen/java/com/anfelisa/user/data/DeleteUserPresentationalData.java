package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class DeleteUserPresentationalData implements IDeleteUserPresentationalData {
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	@NotNull
	private String deletedUsername;
	
	
	public DeleteUserPresentationalData(
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole,
		@JsonProperty("deletedUsername") String deletedUsername
	) {
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.deletedUsername = deletedUsername;
		
	}

	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public DeleteUserPresentationalData withCredentialsUsername(String credentialsUsername) {
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
	public DeleteUserPresentationalData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
	@JsonProperty
	public String getDeletedUsername() {
		return this.deletedUsername;
	}
	public void setDeletedUsername(String deletedUsername) {
		this.deletedUsername = deletedUsername;
	}
	public DeleteUserPresentationalData withDeletedUsername(String deletedUsername) {
		this.deletedUsername = deletedUsername;
		return this;
	}
	
}

/*       S.D.G.       */
