package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ForgotPasswordModel.class)
public interface IForgotPasswordModel {

	String getUsername();
	String getEmail();
	String getName();
	String getPrename();
	String getLanguage();
	String getPassword();


}

/*       S.D.G.       */
