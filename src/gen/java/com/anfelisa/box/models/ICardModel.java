package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardModel.class)
public interface ICardModel {

	String getCardId();
	String getGiven();
	String getWanted();
	Integer getMaxPoints();

}

/*       S.D.G.       */
