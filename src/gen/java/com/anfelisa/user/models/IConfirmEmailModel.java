/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.user.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ConfirmEmailModel.class)
public interface IConfirmEmailModel extends com.anfelisa.user.models.IEmailConfirmationModel{

	String getUsername();
	void setUsername(String username);
	
	String getToken();
	void setToken(String token);
	
	String getUserId();
	void setUserId(String userId);
	
	
	IConfirmEmailModel deepCopy();
}




/******* S.D.G. *******/



