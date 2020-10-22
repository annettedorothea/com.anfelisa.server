/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.user.models.IConfirmEmailModel;

@JsonDeserialize(as=ConfirmEmailData.class)
public interface IConfirmEmailData extends IConfirmEmailModel, IDataContainer {
	void mapFrom(com.anfelisa.user.models.IEmailConfirmationModel model);
	
	IConfirmEmailData withUsername(String username);
	
	IConfirmEmailData withToken(String token);
	
	IConfirmEmailData withUserId(String userId);
	
	
}



/******* S.D.G. *******/



