package com.anfelisa.user.data;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleData extends AbstractData implements IRoleData {
	
	private String username;
	
	private String role;
	

	public RoleData(
		@JsonProperty("username") String username,
		@JsonProperty("role") String role
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.username = username;
		this.role = role;
	}

	public RoleData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public RoleData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public RoleData withRole(String role) {
		this.role = role;
		return this;
	}
	
}

/*       S.D.G.       */
