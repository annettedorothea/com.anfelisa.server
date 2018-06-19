package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class UserUpdatePresentationalData implements IUserUpdatePresentationalData {
	
	@NotNull
	private String editedUsername;
	
	@NotNull
	private String role;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	
	public UserUpdatePresentationalData(
		@JsonProperty("editedUsername") String editedUsername,
		@JsonProperty("role") String role,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
	) {
		this.editedUsername = editedUsername;
		this.role = role;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		
	}

	@JsonProperty
	public String getEditedUsername() {
		return this.editedUsername;
	}
	public void setEditedUsername(String editedUsername) {
		this.editedUsername = editedUsername;
	}
	public UserUpdatePresentationalData withEditedUsername(String editedUsername) {
		this.editedUsername = editedUsername;
		return this;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserUpdatePresentationalData withRole(String role) {
		this.role = role;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public UserUpdatePresentationalData withCredentialsUsername(String credentialsUsername) {
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
	public UserUpdatePresentationalData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
}

/*       S.D.G.       */
