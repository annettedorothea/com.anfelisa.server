package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardSearchModel.class)
public interface ICardSearchModel {

	String getSearchString();
	String getCategoryId();
	java.util.List<com.anfelisa.card.models.ICardModel> getCardList();

}

/*       S.D.G.       */
