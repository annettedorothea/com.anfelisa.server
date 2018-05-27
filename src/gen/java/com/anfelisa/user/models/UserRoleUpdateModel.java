package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class UserRoleUpdateModel implements IUserRoleUpdateModel {

	@NotNull
	private String editedUsername;
	
	@NotNull
	private String role;
	

	public UserRoleUpdateModel(
		@JsonProperty("editedUsername") String editedUsername,
		@JsonProperty("role") String role
	) {
		this.editedUsername = editedUsername;
		this.role = role;
	}

	@JsonProperty
	public String getEditedUsername() {
		return this.editedUsername;
	}
	public void setEditedUsername(String editedUsername) {
		this.editedUsername = editedUsername;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}

/*       S.D.G.       */
