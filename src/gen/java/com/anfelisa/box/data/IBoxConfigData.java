package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxConfigModel;
import com.anfelisa.user.models.IUsernameModel;

@JsonDeserialize(as=BoxConfigData.class)
public interface IBoxConfigData extends IBoxConfigModel, IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
