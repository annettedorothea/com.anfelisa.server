package com.anfelisa.setup.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.setup.models.ISetupModel;

@JsonDeserialize(as=SetupData.class)
public interface ISetupData extends ISetupModel, IDataContainer {

}

/*       S.D.G.       */
