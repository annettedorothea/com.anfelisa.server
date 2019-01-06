package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardWithCategoryNameModel;

@JsonDeserialize(as=CardWithCategoryNameData.class)
public interface ICardWithCategoryNameData extends ICardWithCategoryNameModel, IDataContainer {
	void mapFrom(com.anfelisa.card.models.ICardModel model);
}

/*       S.D.G.       */
