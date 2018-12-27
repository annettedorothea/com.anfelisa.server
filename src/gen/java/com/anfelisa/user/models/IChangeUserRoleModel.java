package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ChangeUserRoleModel.class)
public interface IChangeUserRoleModel {

	String getEditedUserId();
	String getNewRole();
	String getUserId();
	String getRole();

}

/*       S.D.G.       */
