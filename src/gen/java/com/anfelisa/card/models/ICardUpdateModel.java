package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardUpdateModel.class)
public interface ICardUpdateModel {

	String getCardId();
	String getGiven();
	String getWanted();
	Integer getCardIndex();

}

/*       S.D.G.       */
