package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxIdModel;
import com.anfelisa.user.models.IUsernameModel;

@JsonDeserialize(as=DeleteBoxData.class)
public interface IDeleteBoxData extends IBoxIdModel, IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
