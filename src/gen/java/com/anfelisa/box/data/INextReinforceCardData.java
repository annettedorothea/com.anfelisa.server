package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IUserIdModel;
import com.anfelisa.box.models.INextReinforceCardModel;
import com.anfelisa.box.models.IBoxIdModel;

@JsonDeserialize(as=NextReinforceCardData.class)
public interface INextReinforceCardData extends IUserIdModel, INextReinforceCardModel, IBoxIdModel, IDataContainer {

}

/*       S.D.G.       */
