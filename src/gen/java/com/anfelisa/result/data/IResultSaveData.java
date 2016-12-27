package com.anfelisa.result.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.result.models.IResultSaveModel;

@JsonDeserialize(as=ResultSaveData.class)
public interface IResultSaveData extends IResultSaveModel, IDataContainer {

}

/*       S.D.G.       */
