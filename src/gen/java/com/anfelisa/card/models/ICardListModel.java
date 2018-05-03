package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardListModel.class)
public interface ICardListModel {

	String getCategoryId();
	String getCategoryName();
	java.util.List<com.anfelisa.card.models.ICardModel> getCardList();

}

/*       S.D.G.       */
