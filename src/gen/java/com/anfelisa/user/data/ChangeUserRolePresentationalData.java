package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IChangeUserRoleModel;

@SuppressWarnings("all")
public class ChangeUserRolePresentationalData implements IChangeUserRolePresentationalData {
	
	@NotNull
	private String userId;
	
	@NotNull
	private String role;
	
	@NotNull
	private String authUserId;
	
	@NotNull
	private String authRole;
	
	
	public ChangeUserRolePresentationalData(
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
	
	@JsonProperty
	public String getAuthUserId() {
		return this.authUserId;
	}
	public void setAuthUserId(String authUserId) {
		this.authUserId = authUserId;
	}
	public ChangeUserRolePresentationalData withAuthUserId(String authUserId) {
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
	public ChangeUserRolePresentationalData withAuthRole(String authRole) {
		this.authRole = authRole;
		return this;
	}
	
}

/*       S.D.G.       */
