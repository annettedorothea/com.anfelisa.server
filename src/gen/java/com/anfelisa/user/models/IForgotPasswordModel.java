package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ForgotPasswordModel.class)
public interface IForgotPasswordModel extends com.anfelisa.user.models.IResetPasswordModel{

	String getLanguage();
	void setLanguage(String language);
	
	String getEmail();
	void setEmail(String email);
	
	String getUsername();
	void setUsername(String username);
	

}

/*       S.D.G.       */
