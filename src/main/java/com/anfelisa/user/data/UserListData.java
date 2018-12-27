package com.anfelisa.user.data;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserListData extends AbstractData implements IUserListData {
	
	private java.util.List<com.anfelisa.user.models.IUserModel> userList;
	
	private String role;
	

	public UserListData(
		@JsonProperty("userList") java.util.List<com.anfelisa.user.models.IUserModel> userList,
		@JsonProperty("role") String role
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userList = userList;
		this.role = role;
	}

	public UserListData( String uuid ) {
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
