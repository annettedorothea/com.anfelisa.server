package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserListModel.class)
public interface IUserListModel {

	java.util.List<com.anfelisa.user.models.IUserModel> getUserList();
	String getRole();

}

/*       S.D.G.       */
