package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ChangeUserRoleModel implements IChangeUserRoleModel {

	@NotNull
	private String userId;
	
	@NotNull
	private String role;
	
	@NotNull
	private String authUserId;
	
	@NotNull
	private String authRole;
	

	public ChangeUserRoleModel(
		@JsonProperty("userId") String userId,
		@JsonProperty("role") String role,
		@JsonProperty("authUserId") String authUserId,
		@JsonProperty("authRole") String authRole
	) {
		this.userId = userId;
		this.role = role;
		this.authUserId = authUserId;
		this.authRole = authRole;
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
	
	@JsonProperty
	public String getAuthUserId() {
		return this.authUserId;
	}
	public void setAuthUserId(String authUserId) {
		this.authUserId = authUserId;
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
