/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.user.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ForgotPasswordModel.class)
public interface IForgotPasswordModel {

	String getLanguage();
	void setLanguage(String language);
	
	String getEmail();
	void setEmail(String email);
	
	String getUsername();
	void setUsername(String username);
	
	String getToken();
	void setToken(String token);
	
	String getUserId();
	void setUserId(String userId);
	
	
}




/******* S.D.G. *******/



