package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserPasswordUpdateModel.class)
public interface IUserPasswordUpdateModel {

	String getEditedUsername();
	String getNewPassword();

}

/*       S.D.G.       */
