package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=EmailConfirmationModel.class)
public interface IEmailConfirmationModel {

	String getToken();
	String getUserId();

}

/*       S.D.G.       */
