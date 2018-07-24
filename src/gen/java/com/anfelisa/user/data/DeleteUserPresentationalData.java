package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IDeleteUserModel;

@SuppressWarnings("all")
public class DeleteUserPresentationalData implements IDeleteUserPresentationalData {
	
	@NotNull
	private String deletedUsername;
	
	@NotNull
	private String authUsername;
	
	@NotNull
	private String authRole;
	
	
	public DeleteUserPresentationalData(
		@JsonProperty("deletedUsername") String deletedUsername,
		@JsonProperty("authUsername") String authUsername,
		@JsonProperty("authRole") String authRole
	) {
		this.deletedUsername = deletedUsername;
		this.authUsername = authUsername;
		this.authRole = authRole;
		
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
	
	@JsonProperty
	public String getAuthUsername() {
		return this.authUsername;
	}
	public void setAuthUsername(String authUsername) {
		this.authUsername = authUsername;
	}
	public DeleteUserPresentationalData withAuthUsername(String authUsername) {
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
	public DeleteUserPresentationalData withAuthRole(String authRole) {
		this.authRole = authRole;
		return this;
	}
	
}

/*       S.D.G.       */
