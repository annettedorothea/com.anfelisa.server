package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardDeleteModel.class)
public interface ICardDeleteModel {

	String getCardId();
	Integer getCardIndex();
	String getCategoryId();
	String getUserId();

}

/*       S.D.G.       */
