package com.anfelisa.result.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.result.models.IResultModel;

@JsonDeserialize(as=ResultCreationData.class)
public interface IResultCreationData extends IResultModel, IDataContainer {

}

/*       S.D.G.       */
