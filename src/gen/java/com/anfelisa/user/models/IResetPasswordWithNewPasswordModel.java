/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.user.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ResetPasswordWithNewPasswordModel.class)
public interface IResetPasswordWithNewPasswordModel {

	String getPassword();
	void setPassword(String password);
	
	String getToken();
	void setToken(String token);
	
	String getUserId();
	void setUserId(String userId);
	
	
	IResetPasswordWithNewPasswordModel deepCopy();
}




/******* S.D.G. *******/



