package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserUpdateData extends AbstractData implements IUserUpdateData {
	
	@NotNull
	private String editedUsername;
	
	@NotNull
	private String role;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	

	public UserUpdateData(
		@JsonProperty("editedUsername") String editedUsername,
		@JsonProperty("role") String role,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.editedUsername = editedUsername;
		this.role = role;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
	}

	public UserUpdateData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getEditedUsername() {
		return this.editedUsername;
	}
	public void setEditedUsername(String editedUsername) {
		this.editedUsername = editedUsername;
	}
	public UserUpdateData withEditedUsername(String editedUsername) {
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
	public UserUpdateData withRole(String role) {
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
	public UserUpdateData withCredentialsUsername(String credentialsUsername) {
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
	public UserUpdateData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new UserUpdatePresentationalData(
			this.editedUsername,
			this.role,
			this.credentialsUsername,
			this.credentialsRole
		);
	}

}

/*       S.D.G.       */
