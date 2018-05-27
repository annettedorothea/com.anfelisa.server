package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardModel;

@JsonDeserialize(as=CardCreationData.class)
public interface ICardCreationData extends ICardModel, IDataContainer {

}

/*       S.D.G.       */
