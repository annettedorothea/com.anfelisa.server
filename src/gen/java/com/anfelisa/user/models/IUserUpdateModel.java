package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserUpdateModel.class)
public interface IUserUpdateModel {

	String getUsername();
	String getName();
	String getPrename();
	String getEmail();

}

/*       S.D.G.       */
