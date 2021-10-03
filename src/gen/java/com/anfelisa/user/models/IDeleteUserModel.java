/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.user.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=DeleteUserModel.class)
public interface IDeleteUserModel {

	String getUsernameToBeDeleted();
	void setUsernameToBeDeleted(String usernameToBeDeleted);
	
	String getUsername();
	void setUsername(String username);
	
	String getUserId();
	void setUserId(String userId);
	
	String getRole();
	void setRole(String role);
	
	java.util.List<String> getBoxIds();
	void setBoxIds(java.util.List<String> boxIds);
	
	java.util.List<String> getRootCategoryIds();
	void setRootCategoryIds(java.util.List<String> rootCategoryIds);
	
	
	IDeleteUserModel deepCopy();
}




/******* S.D.G. *******/



