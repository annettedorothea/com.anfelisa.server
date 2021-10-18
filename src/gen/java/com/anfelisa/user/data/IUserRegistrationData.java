/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.user.models.IUserRegistrationModel;

@JsonDeserialize(as=UserRegistrationData.class)
public interface IUserRegistrationData extends IUserRegistrationModel, IDataContainer {
	void mapFrom(com.anfelisa.user.models.IUserModel model);
	void mapFrom(com.anfelisa.user.models.IEmailConfirmationModel model);
	
	IUserRegistrationData withLanguage(String language);
	
	IUserRegistrationData withUserId(String userId);
	
	IUserRegistrationData withUsername(String username);
	
	IUserRegistrationData withPassword(String password);
	
	IUserRegistrationData withEmail(String email);
	
	IUserRegistrationData withRole(String role);
	
	IUserRegistrationData withEmailConfirmed(Boolean emailConfirmed);
	
	IUserRegistrationData withToken(String token);
	
	
	IUserRegistrationData deepCopy();
}



/******* S.D.G. *******/



