package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserRegistrationModel.class)
public interface IUserRegistrationModel {

	String getUsername();
	String getPassword();
	String getEmail();
	String getRole();

}

/*       S.D.G.       */
