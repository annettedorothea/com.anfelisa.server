package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UsernameAvailableModel.class)
public interface IUsernameAvailableModel {

	String getUsername();
	void setUsername(String username);
	
	Boolean getAvailable();
	void setAvailable(Boolean available);
	
	
}

/*       S.D.G.       */
