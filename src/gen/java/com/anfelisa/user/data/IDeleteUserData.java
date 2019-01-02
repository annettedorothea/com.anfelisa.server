package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IDeleteUserModel;

@JsonDeserialize(as=DeleteUserData.class)
public interface IDeleteUserData extends IDeleteUserModel, IDataContainer {
}

/*       S.D.G.       */
