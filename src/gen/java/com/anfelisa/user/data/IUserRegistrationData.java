package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserRegistrationModel;

@JsonDeserialize(as=UserRegistrationData.class)
public interface IUserRegistrationData extends IUserRegistrationModel, IDataContainer {

}

/*       S.D.G.       */
