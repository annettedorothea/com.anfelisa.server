package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardDeleteModel.class)
public interface ICardDeleteModel {

	String getCardId();
	void setCardId(String cardId);
	
	Integer getCardIndex();
	void setCardIndex(Integer cardIndex);
	
	String getCategoryId();
	void setCategoryId(String categoryId);
	
	String getUserId();
	void setUserId(String userId);
	
	
}

/*       S.D.G.       */
