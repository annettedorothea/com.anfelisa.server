package com.anfelisa.user.data;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserListData extends AbstractData implements IUserListData {
	
	private java.util.List<com.anfelisa.user.models.IUserModel> userList;
	

	public UserListData(
		@JsonProperty("userList") java.util.List<com.anfelisa.user.models.IUserModel> userList
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userList = userList;
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
	public UserListData withUserList(java.util.List<com.anfelisa.user.models.IUserModel> userList) {
		this.userList = userList;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new UserListPresentationalData(
			this.userList
		);
	}

}

/*       S.D.G.       */
