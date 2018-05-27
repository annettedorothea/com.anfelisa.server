package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUsernameModel;

@JsonDeserialize(as=UsernameData.class)
public interface IUsernameData extends IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
