package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IFillBoxModel;
import com.anfelisa.user.models.IUsernameModel;

@JsonDeserialize(as=FillBoxData.class)
public interface IFillBoxData extends IFillBoxModel, IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
