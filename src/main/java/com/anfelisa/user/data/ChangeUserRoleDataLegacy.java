package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChangeUserRoleDataLegacy extends AbstractData implements IChangeUserRoleData {
	
	@NotNull
	private String userId;
	
	@NotNull
	private String role;
	
	@NotNull
	private String authUserId;
	
	@NotNull
	private String authRole;
	

	public ChangeUserRoleDataLegacy(
		@JsonProperty("userId") String userId,
		@JsonProperty("role") String role,
		@JsonProperty("authUserId") String authUserId,
		@JsonProperty("authRole") String authRole
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.role = role;
		this.authUserId = authUserId;
		this.authRole = authRole;
	}

	public ChangeUserRoleDataLegacy( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ChangeUserRoleDataLegacy withUserId(String userId) {
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
	public ChangeUserRoleDataLegacy withRole(String role) {
		this.role = role;
		return this;
	}
	
	@JsonProperty
	public String getAuthUserId() {
		return this.authUserId;
	}
	public void setAuthUserId(String authUserId) {
		this.authUserId = authUserId;
	}
	public ChangeUserRoleDataLegacy withAuthUserId(String authUserId) {
		this.authUserId = authUserId;
		return this;
	}
	
	@JsonProperty
	public String getAuthRole() {
		return this.authRole;
	}
	public void setAuthRole(String authRole) {
		this.authRole = authRole;
	}
	public ChangeUserRoleDataLegacy withAuthRole(String authRole) {
		this.authRole = authRole;
		return this;
	}

	@Override
	public String getEditedUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNewRole() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

/*       S.D.G.       */
