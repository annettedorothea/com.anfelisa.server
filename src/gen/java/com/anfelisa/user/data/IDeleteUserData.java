/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.user.models.IDeleteUserModel;

@JsonDeserialize(as=DeleteUserData.class)
public interface IDeleteUserData extends IDeleteUserModel, IDataContainer {
	
	IDeleteUserData withUsernameToBeDeleted(String usernameToBeDeleted);
	
	IDeleteUserData withUsername(String username);
	
	IDeleteUserData withUserId(String userId);
	
	IDeleteUserData withRole(String role);
	
	IDeleteUserData withBoxIds(java.util.List<String> boxIds);
	
	IDeleteUserData withRootCategoryIds(java.util.List<String> rootCategoryIds);
	
	
}



/******* S.D.G. *******/



