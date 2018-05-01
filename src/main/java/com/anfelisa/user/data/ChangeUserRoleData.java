package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

public class ChangeUserRoleData extends AbstractData implements IChangeUserRoleData {
	
	@NotNull
	private String userId;
	
	private String role;
	

	public ChangeUserRoleData(
		@JsonProperty("userId") String userId,
		@JsonProperty("role") String role
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.role = role;
	}

	public ChangeUserRoleData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ChangeUserRoleData withUserId(String userId) {
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
	public ChangeUserRoleData withRole(String role) {
		this.role = role;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new ChangeUserRolePresentationalData(
			this.userId,
			this.role
		);
	}

}

/*       S.D.G.       */
