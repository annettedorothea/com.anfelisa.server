package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxIdModel;
import com.anfelisa.user.models.ICredentialsModel;

@JsonDeserialize(as=DeleteBoxData.class)
public interface IDeleteBoxData extends IBoxIdModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
