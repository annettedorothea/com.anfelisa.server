package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ResetPasswordModel.class)
public interface IResetPasswordModel {

	String getToken();
	String getUserId();

}

/*       S.D.G.       */
