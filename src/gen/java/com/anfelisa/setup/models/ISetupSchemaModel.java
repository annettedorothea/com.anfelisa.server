package com.anfelisa.setup.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=SetupSchemaModel.class)
public interface ISetupSchemaModel {

	String getSchemaToBeCreated();


}

/*       S.D.G.       */
