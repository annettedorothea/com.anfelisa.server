package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserRegistrationModel.class)
public interface IUserRegistrationModel extends com.anfelisa.user.models.IUserModel,com.anfelisa.user.models.IEmailConfirmationModel{

	String getLanguage();
	void setLanguage(String language);
	

}

/*       S.D.G.       */
