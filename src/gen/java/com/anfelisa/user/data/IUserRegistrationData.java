package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.ILanguageModel;

@JsonDeserialize(as=UserRegistrationData.class)
public interface IUserRegistrationData extends IUserModel, ILanguageModel, IDataContainer {

}

/*       S.D.G.       */
