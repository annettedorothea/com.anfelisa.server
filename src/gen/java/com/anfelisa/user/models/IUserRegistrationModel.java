package com.anfelisa.user.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=UserRegistrationModel.class)
public interface IUserRegistrationModel extends com.anfelisa.user.models.IUserModel,com.anfelisa.user.models.IEmailConfirmationModel{

	String getLanguage();
	void setLanguage(String language);
	
	
	List<String> equalsPrimitiveTypes(IUserRegistrationModel other);
	
}

/*       S.D.G.       */
