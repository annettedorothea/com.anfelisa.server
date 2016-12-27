package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardModel.class)
public interface ICardModel {

	Integer getCardId();
	String getContent();
	Integer getTestId();
	String getContentHash();
	Integer getMaxPoints();


}

/*       S.D.G.       */
