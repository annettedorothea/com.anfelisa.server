package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class DeleteUserModel implements IDeleteUserModel {

	@NotNull
	private String deletedUsername;
	
	@NotNull
	private String authUsername;
	
	@NotNull
	private String authRole;
	

	public DeleteUserModel(
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
	
	@JsonProperty
	public String getAuthUsername() {
		return this.authUsername;
	}
	public void setAuthUsername(String authUsername) {
		this.authUsername = authUsername;
	}
	
	@JsonProperty
	public String getAuthRole() {
		return this.authRole;
	}
	public void setAuthRole(String authRole) {
		this.authRole = authRole;
	}
	

}

/*       S.D.G.       */
