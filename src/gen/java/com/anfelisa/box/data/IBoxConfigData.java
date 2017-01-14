package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxConfigModel;
import com.anfelisa.user.models.ICredentialsModel;

@JsonDeserialize(as=BoxConfigData.class)
public interface IBoxConfigData extends IBoxConfigModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
