package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardUpdateModel.class)
public interface ICardUpdateModel {

	String getCardId();
	String getGiven();
	String getWanted();
	String getImage();

}

/*       S.D.G.       */
