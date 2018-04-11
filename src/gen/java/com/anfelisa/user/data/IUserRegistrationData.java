package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserRegistrationModel;
import com.anfelisa.user.models.ILanguageModel;

@JsonDeserialize(as=UserRegistrationData.class)
public interface IUserRegistrationData extends IUserRegistrationModel, ILanguageModel, IDataContainer {

}

/*       S.D.G.       */
