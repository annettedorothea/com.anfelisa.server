/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.user.models.IResetPasswordModel;

@JsonDeserialize(as=ResetPasswordData.class)
public interface IResetPasswordData extends IResetPasswordModel, IDataContainer {
	
	IResetPasswordData withToken(String token);
	
	IResetPasswordData withUserId(String userId);
	
	
	IResetPasswordData deepCopy();
}



/******* S.D.G. *******/



