/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.user.models.IUserModel;

@JsonDeserialize(as=UserData.class)
public interface IUserData extends IUserModel, IDataContainer {
	
	IUserData withUserId(String userId);
	
	IUserData withUsername(String username);
	
	IUserData withPassword(String password);
	
	IUserData withEmail(String email);
	
	IUserData withRole(String role);
	
	IUserData withEmailConfirmed(Boolean emailConfirmed);
	
	
	IUserData deepCopy();
}



/******* S.D.G. *******/



