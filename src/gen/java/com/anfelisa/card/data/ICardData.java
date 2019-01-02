package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardModel;

@JsonDeserialize(as=CardData.class)
public interface ICardData extends ICardModel, IDataContainer {
}

/*       S.D.G.       */
