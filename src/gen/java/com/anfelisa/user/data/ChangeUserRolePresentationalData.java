package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class ChangeUserRolePresentationalData implements IChangeUserRolePresentationalData {
	
	@NotNull
	private String userId;
	
	private String role;
	
	
	public ChangeUserRolePresentationalData(
		@JsonProperty("userId") String userId,
		@JsonProperty("role") String role
	) {
		this.userId = userId;
		this.role = role;
		
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ChangeUserRolePresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public ChangeUserRolePresentationalData withRole(String role) {
		this.role = role;
		return this;
	}
	
}

/*       S.D.G.       */
