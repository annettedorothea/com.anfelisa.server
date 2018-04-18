package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChangeUserRoleData extends AbstractData implements IChangeUserRoleData {
	
	@NotNull
	private String username;
	
	private String role;
	

	public ChangeUserRoleData(
		@JsonProperty("username") String username,
		@JsonProperty("role") String role
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.username = username;
		this.role = role;
	}

	public ChangeUserRoleData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ChangeUserRoleData withUsername(String username) {
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
	public ChangeUserRoleData withRole(String role) {
		this.role = role;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new ChangeUserRolePresentationalData(
			this.username,
			this.role
		);
	}

}

/*       S.D.G.       */
