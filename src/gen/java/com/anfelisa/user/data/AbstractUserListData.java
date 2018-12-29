package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

@SuppressWarnings("unused")
public abstract class AbstractUserListData extends AbstractData implements IUserListData {
	
	private java.util.List<com.anfelisa.user.models.IUserModel> userList;
	
	private String role;
	

	public AbstractUserListData(
		@JsonProperty("userList") java.util.List<com.anfelisa.user.models.IUserModel> userList,
		@JsonProperty("role") String role
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userList = userList;
		this.role = role;
	}

	public AbstractUserListData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public java.util.List<com.anfelisa.user.models.IUserModel> getUserList() {
		return this.userList;
	}
	public void setUserList(java.util.List<com.anfelisa.user.models.IUserModel> userList) {
		this.userList = userList;
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
