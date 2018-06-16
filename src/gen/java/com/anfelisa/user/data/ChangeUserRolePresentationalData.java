package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserIdModel;
import com.anfelisa.user.models.IRoleModel;

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
