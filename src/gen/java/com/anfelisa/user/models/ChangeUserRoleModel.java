package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ChangeUserRoleModel implements IChangeUserRoleModel {

	@NotNull
	private String editedUserId;
	
	@NotNull
	private String newRole;
	
	@NotNull
	private String userId;
	
	@NotNull
	private String role;
	

	public ChangeUserRoleModel(
		@JsonProperty("editedUserId") String editedUserId,
		@JsonProperty("newRole") String newRole,
		@JsonProperty("userId") String userId,
		@JsonProperty("role") String role
	) {
		this.editedUserId = editedUserId;
		this.newRole = newRole;
		this.userId = userId;
		this.role = role;
	}

	@JsonProperty
	public String getEditedUserId() {
		return this.editedUserId;
	}
	public void setEditedUserId(String editedUserId) {
		this.editedUserId = editedUserId;
	}
	
	@JsonProperty
	public String getNewRole() {
		return this.newRole;
	}
	public void setNewRole(String newRole) {
		this.newRole = newRole;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
