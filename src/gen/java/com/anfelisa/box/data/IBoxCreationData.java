package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.user.models.ICredentialsModel;

@JsonDeserialize(as=BoxCreationData.class)
public interface IBoxCreationData extends IBoxModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
