/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.user.models.IResetPasswordWithNewPasswordModel;

@JsonDeserialize(as=ResetPasswordWithNewPasswordData.class)
public interface IResetPasswordWithNewPasswordData extends IResetPasswordWithNewPasswordModel, IDataContainer {
	
	IResetPasswordWithNewPasswordData withPassword(String password);
	
	IResetPasswordWithNewPasswordData withToken(String token);
	
	IResetPasswordWithNewPasswordData withUserId(String userId);
	
	
}



/******* S.D.G. *******/



