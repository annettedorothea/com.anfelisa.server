package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserModel;

@JsonDeserialize(as=UserData.class)
public interface IUserData extends IUserModel, IDataContainer {

}

/*       S.D.G.       */
