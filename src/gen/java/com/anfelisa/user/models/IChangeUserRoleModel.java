package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ChangeUserRoleModel.class)
public interface IChangeUserRoleModel {

	String getUserId();
	String getRole();
	String getAuthUserId();
	String getAuthRole();

}

/*       S.D.G.       */
