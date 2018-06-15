package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class UserListModel implements IUserListModel {

	private java.util.List<com.anfelisa.user.models.IUserModel> userList;
	

	public UserListModel(
		@JsonProperty("userList") java.util.List<com.anfelisa.user.models.IUserModel> userList
	) {
		this.userList = userList;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.user.models.IUserModel> getUserList() {
		return this.userList;
	}
	public void setUserList(java.util.List<com.anfelisa.user.models.IUserModel> userList) {
		this.userList = userList;
	}
	

}

/*       S.D.G.       */
