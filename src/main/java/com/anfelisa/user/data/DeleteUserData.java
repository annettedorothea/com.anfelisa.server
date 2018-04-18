package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteUserData extends AbstractData implements IDeleteUserData {
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	@NotNull
	private String deletedUsername;
	

	public DeleteUserData(
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole,
		@JsonProperty("deletedUsername") String deletedUsername
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.deletedUsername = deletedUsername;
	}

	public DeleteUserData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public DeleteUserData withCredentialsUsername(String credentialsUsername) {
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
	public DeleteUserData withCredentialsRole(String credentialsRole) {
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
	public DeleteUserData withDeletedUsername(String deletedUsername) {
		this.deletedUsername = deletedUsername;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new DeleteUserPresentationalData(
			this.credentialsUsername,
			this.credentialsRole,
			this.deletedUsername
		);
	}

}

/*       S.D.G.       */
