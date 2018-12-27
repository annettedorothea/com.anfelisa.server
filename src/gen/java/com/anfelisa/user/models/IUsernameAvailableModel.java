package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UsernameAvailableModel.class)
public interface IUsernameAvailableModel {

	String getUsername();
	Boolean getAvailable();

}

/*       S.D.G.       */
