package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.INextReinforceCardModel;

@JsonDeserialize(as=NextReinforceCardData.class)
public interface INextReinforceCardData extends INextReinforceCardModel, IDataContainer {
	void mapFrom(com.anfelisa.box.models.INextReinforceCardViewModel model);
}

/*       S.D.G.       */
