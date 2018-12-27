package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserIdModel;

@JsonDeserialize(as=UserIdData.class)
public interface IUserIdData extends IUserIdModel, IDataContainer {

}

/*       S.D.G.       */
