package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ConfirmEmailModel.class)
public interface IConfirmEmailModel extends com.anfelisa.user.models.IEmailConfirmationModel{

	String getUsername();
	void setUsername(String username);
	
	
}

/*       S.D.G.       */
