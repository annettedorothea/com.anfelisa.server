package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserListModel.class)
public interface IUserListModel {

	java.util.List<com.anfelisa.user.models.IUserModel> getUserList();
	void setUserList(java.util.List<com.anfelisa.user.models.IUserModel> userList);
	
	String getRole();
	void setRole(String role);
	
	
}

/*       S.D.G.       */
