package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserModel.class)
public interface IUserModel {

	String getUsername();
	String getPassword();
	String getName();
	String getPrename();
	String getEmail();
	String getRole();
	Boolean getEmailConfirmed();

}

/*       S.D.G.       */
