package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserRoleUpdateModel.class)
public interface IUserRoleUpdateModel {

	String getEditedUsername();
	String getRole();

}

/*       S.D.G.       */
