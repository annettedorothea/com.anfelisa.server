/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.user.models.IForgotPasswordModel;

@JsonDeserialize(as=ForgotPasswordData.class)
public interface IForgotPasswordData extends IForgotPasswordModel, IDataContainer {
	
	IForgotPasswordData withLanguage(String language);
	
	IForgotPasswordData withEmail(String email);
	
	IForgotPasswordData withUsername(String username);
	
	IForgotPasswordData withToken(String token);
	
	IForgotPasswordData withUserId(String userId);
	
	
}



/******* S.D.G. *******/



