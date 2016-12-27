package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserUpdateModel;

@JsonDeserialize(as=UserUpdateData.class)
public interface IUserUpdateData extends IUserUpdateModel, IDataContainer {

}

/*       S.D.G.       */
