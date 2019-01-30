package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IForgotPasswordModel;

@JsonDeserialize(as=ForgotPasswordData.class)
public interface IForgotPasswordData extends IForgotPasswordModel, IDataContainer {
	void mapFrom(com.anfelisa.user.models.IResetPasswordModel model);
	
	IForgotPasswordData withLanguage(String language);
	
	IForgotPasswordData withEmail(String email);
	
	IForgotPasswordData withUsername(String username);
	
	IForgotPasswordData withToken(String token);
	
	IForgotPasswordData withUserId(String userId);
	
	
}

/*       S.D.G.       */
