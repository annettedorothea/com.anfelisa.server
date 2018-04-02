package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardModel.class)
public interface ICardModel {

	String getCardId();
	String getContent();
	String getTestId();
	String getContentHash();
	Integer getMaxPoints();

}

/*       S.D.G.       */
