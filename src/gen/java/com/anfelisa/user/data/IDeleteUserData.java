package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IDeleteUserModel;

@JsonDeserialize(as=DeleteUserData.class)
public interface IDeleteUserData extends IDeleteUserModel, IDataContainer {
	
	IDeleteUserData withUsernameToBeDeleted(String usernameToBeDeleted);
	
	IDeleteUserData withUsername(String username);
	
	IDeleteUserData withRole(String role);
	
	
}

/*       S.D.G.       */
