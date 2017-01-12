package com.anfelisa.setup.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.setup.models.IInitialUserModel;
import com.anfelisa.user.models.ILanguageModel;

@JsonDeserialize(as=SetupSchemaData.class)
public interface ISetupSchemaData extends IInitialUserModel, ILanguageModel, IDataContainer {

}

/*       S.D.G.       */
