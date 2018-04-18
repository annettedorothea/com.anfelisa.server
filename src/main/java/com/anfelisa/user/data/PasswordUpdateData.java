package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PasswordUpdateData extends AbstractData implements IPasswordUpdateData {
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	@NotNull
	private String editedUsername;
	
	@NotNull
	private String newPassword;
	

	public PasswordUpdateData(
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole,
		@JsonProperty("editedUsername") String editedUsername,
		@JsonProperty("newPassword") String newPassword
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.editedUsername = editedUsername;
		this.newPassword = newPassword;
	}

	public PasswordUpdateData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public PasswordUpdateData withCredentialsUsername(String credentialsUsername) {
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
	public PasswordUpdateData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
	@JsonProperty
	public String getEditedUsername() {
		return this.editedUsername;
	}
	public void setEditedUsername(String editedUsername) {
		this.editedUsername = editedUsername;
	}
	public PasswordUpdateData withEditedUsername(String editedUsername) {
		this.editedUsername = editedUsername;
		return this;
	}
	
	@JsonProperty
	public String getNewPassword() {
		return this.newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public PasswordUpdateData withNewPassword(String newPassword) {
		this.newPassword = newPassword;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new PasswordUpdatePresentationalData(
			this.credentialsUsername,
			this.credentialsRole,
			this.editedUsername,
			this.newPassword
		);
	}

}

/*       S.D.G.       */
