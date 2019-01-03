package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ResetPasswordModel.class)
public interface IResetPasswordModel {

	String getToken();
	void setToken(String token);
	
	String getUserId();
	void setUserId(String userId);
	

}

/*       S.D.G.       */
