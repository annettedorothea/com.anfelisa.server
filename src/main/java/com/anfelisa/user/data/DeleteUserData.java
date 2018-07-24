package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteUserData extends AbstractData implements IDeleteUserData {
	
	@NotNull
	private String deletedUsername;
	
	@NotNull
	private String authUsername;
	
	@NotNull
	private String authRole;
	

	public DeleteUserData(
		@JsonProperty("deletedUsername") String deletedUsername,
		@JsonProperty("authUsername") String authUsername,
		@JsonProperty("authRole") String authRole
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.deletedUsername = deletedUsername;
		this.authUsername = authUsername;
		this.authRole = authRole;
	}

	public DeleteUserData( String uuid ) {
		super(uuid);
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
	
	@JsonProperty
	public String getAuthUsername() {
		return this.authUsername;
	}
	public void setAuthUsername(String authUsername) {
		this.authUsername = authUsername;
	}
	public DeleteUserData withAuthUsername(String authUsername) {
		this.authUsername = authUsername;
		return this;
	}
	
	@JsonProperty
	public String getAuthRole() {
		return this.authRole;
	}
	public void setAuthRole(String authRole) {
		this.authRole = authRole;
	}
	public DeleteUserData withAuthRole(String authRole) {
		this.authRole = authRole;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new DeleteUserPresentationalData(
			this.deletedUsername,
			this.authUsername,
			this.authRole
		);
	}

}

/*       S.D.G.       */
