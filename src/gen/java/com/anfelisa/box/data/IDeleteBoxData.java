package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserIdModel;
import com.anfelisa.box.models.IBoxIdModel;

@JsonDeserialize(as=DeleteBoxData.class)
public interface IDeleteBoxData extends IUserIdModel, IBoxIdModel, IDataContainer {

}

/*       S.D.G.       */
