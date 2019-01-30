package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IResetPasswordWithNewPasswordModel;

@JsonDeserialize(as=ResetPasswordWithNewPasswordData.class)
public interface IResetPasswordWithNewPasswordData extends IResetPasswordWithNewPasswordModel, IDataContainer {
	void mapFrom(com.anfelisa.user.models.IResetPasswordModel model);
	
	IResetPasswordWithNewPasswordData withPassword(String password);
	
	IResetPasswordWithNewPasswordData withToken(String token);
	
	IResetPasswordWithNewPasswordData withUserId(String userId);
	
	
}

/*       S.D.G.       */
