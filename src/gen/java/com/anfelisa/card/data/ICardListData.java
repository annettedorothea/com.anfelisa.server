package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardListModel;

@JsonDeserialize(as=CardListData.class)
public interface ICardListData extends ICardListModel, IDataContainer {

}

/*       S.D.G.       */
