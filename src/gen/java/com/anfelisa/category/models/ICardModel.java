package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardModel.class)
public interface ICardModel {

	String getCardId();
	String getGiven();
	String getWanted();
	Boolean getComplex();
	String getCardAuthor();
	Integer getCardIndex();
	String getCategoryId();

}

/*       S.D.G.       */
