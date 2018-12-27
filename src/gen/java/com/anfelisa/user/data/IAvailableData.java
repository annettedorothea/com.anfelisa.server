package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IAvailableModel;

@JsonDeserialize(as=AvailableData.class)
public interface IAvailableData extends IAvailableModel, IDataContainer {

}

/*       S.D.G.       */
