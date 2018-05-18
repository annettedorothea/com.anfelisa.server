package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardSearchModel.class)
public interface ICardSearchModel {

	String getGiven();
	String getWanted();
	String getCategoryId();
	java.util.List<com.anfelisa.card.models.ICardModel> getCardList();
	Boolean getNaturalInputOrder();

}

/*       S.D.G.       */
