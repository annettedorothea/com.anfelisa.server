package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IFillBoxModel;
import com.anfelisa.user.models.ICredentialsModel;
import com.anfelisa.box.models.INowModel;

@JsonDeserialize(as=FillBoxData.class)
public interface IFillBoxData extends IFillBoxModel, ICredentialsModel, INowModel, IDataContainer {

}

/*       S.D.G.       */
