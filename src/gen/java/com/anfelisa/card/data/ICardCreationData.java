package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardCreationModel;

@JsonDeserialize(as=CardCreationData.class)
public interface ICardCreationData extends ICardCreationModel, IDataContainer {
	void mapFrom(com.anfelisa.card.models.ICardModel model);
}

/*       S.D.G.       */
