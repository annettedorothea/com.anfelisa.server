package com.anfelisa.result.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.result.models.IResultModel;
import com.anfelisa.box.models.IFillBoxModel;
import com.anfelisa.user.models.ICredentialsModel;

@JsonDeserialize(as=ResultSaveData.class)
public interface IResultSaveData extends IResultModel, IFillBoxModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
