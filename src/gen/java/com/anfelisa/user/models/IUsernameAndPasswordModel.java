package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UsernameAndPasswordModel.class)
public interface IUsernameAndPasswordModel {

	String getUsername();
	String getPassword();


}

/*       S.D.G.       */
