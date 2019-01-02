package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.INextCardModel;

@JsonDeserialize(as=NextCardData.class)
public interface INextCardData extends INextCardModel, IDataContainer {
	void mapFrom(com.anfelisa.box.models.INextCardViewModel model);
}

/*       S.D.G.       */
