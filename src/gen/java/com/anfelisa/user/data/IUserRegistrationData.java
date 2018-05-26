package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.ILanguageModel;
import com.anfelisa.user.models.IEmailConfirmationModel;

@JsonDeserialize(as=UserRegistrationData.class)
public interface IUserRegistrationData extends IUserModel, ILanguageModel, IEmailConfirmationModel, IDataContainer {

}

/*       S.D.G.       */
