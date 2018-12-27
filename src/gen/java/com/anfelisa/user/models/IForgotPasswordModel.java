package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ForgotPasswordModel.class)
public interface IForgotPasswordModel extends com.anfelisa.user.models.IResetPasswordModel{

	String getLanguage();
	String getEmail();
	String getUsername();

}

/*       S.D.G.       */
