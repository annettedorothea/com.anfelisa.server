package com.anfelisa.user.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ForgotPasswordModel.class)
public interface IForgotPasswordModel extends com.anfelisa.user.models.IResetPasswordModel{

	String getLanguage();
	void setLanguage(String language);
	
	String getEmail();
	void setEmail(String email);
	
	String getUsername();
	void setUsername(String username);
	
	
	List<String> equalsPrimitiveTypes(IForgotPasswordModel other);
	
}

/*       S.D.G.       */
