package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=DeleteUserModel.class)
public interface IDeleteUserModel {

	String getUsernameToBeDeleted();
	void setUsernameToBeDeleted(String usernameToBeDeleted);
	
	String getUsername();
	void setUsername(String username);
	
	String getRole();
	void setRole(String role);
	

}

/*       S.D.G.       */
