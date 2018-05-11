package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class RoleModel implements IRoleModel {

	private String role;
	

	public RoleModel(
		@JsonProperty("role") String role
	) {
		this.role = role;
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
