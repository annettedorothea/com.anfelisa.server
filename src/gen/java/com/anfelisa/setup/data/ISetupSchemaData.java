package com.anfelisa.setup.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.setup.models.ISetupSchemaModel;

@JsonDeserialize(as=SetupSchemaData.class)
public interface ISetupSchemaData extends ISetupSchemaModel, IDataContainer {

}

/*       S.D.G.       */
