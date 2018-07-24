package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=DeleteUserModel.class)
public interface IDeleteUserModel {

	String getDeletedUsername();
	String getAuthUsername();
	String getAuthRole();

}

/*       S.D.G.       */
