package com.anfelisa.setup.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=SchemaCreationModel.class)
public interface ISchemaCreationModel {

	String getSchemaToBeCreated();


}

/*       S.D.G.       */
