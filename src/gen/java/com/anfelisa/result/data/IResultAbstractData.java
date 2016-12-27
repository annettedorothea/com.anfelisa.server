package com.anfelisa.result.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.result.models.IResultAbstractModel;

@JsonDeserialize(as=ResultAbstractData.class)
public interface IResultAbstractData extends IResultAbstractModel, IDataContainer {

}

/*       S.D.G.       */
