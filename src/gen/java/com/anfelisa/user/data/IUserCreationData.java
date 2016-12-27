package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserModel;

@JsonDeserialize(as=UserCreationData.class)
public interface IUserCreationData extends IUserModel, IDataContainer {

}

/*       S.D.G.       */
