package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IResetPasswordModel;

@JsonDeserialize(as=ResetPasswordData.class)
public interface IResetPasswordData extends IResetPasswordModel, IDataContainer {
	
	IResetPasswordData withToken(String token);
	
	IResetPasswordData withUserId(String userId);
	
	
}

/*       S.D.G.       */
