/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.user.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=UserModel.class)
public interface IUserModel {

	String getUserId();
	void setUserId(String userId);
	
	String getUsername();
	void setUsername(String username);
	
	String getPassword();
	void setPassword(String password);
	
	String getEmail();
	void setEmail(String email);
	
	String getRole();
	void setRole(String role);
	
	Boolean getEmailConfirmed();
	void setEmailConfirmed(Boolean emailConfirmed);
	
	
	IUserModel deepCopy();
}




/******* S.D.G. *******/



