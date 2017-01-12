package com.anfelisa.setup.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.setup.models.ISchemaCreationModel;

@JsonDeserialize(as=SchemaCreationData.class)
public interface ISchemaCreationData extends ISchemaCreationModel, IDataContainer {

}

/*       S.D.G.       */
