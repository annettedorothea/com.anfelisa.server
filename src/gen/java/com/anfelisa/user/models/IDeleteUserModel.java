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
	
	String getRole();
	void setRole(String role);
	
	
	List<String> equalsPrimitiveTypes(IDeleteUserModel other);
	
}

/*       S.D.G.       */
