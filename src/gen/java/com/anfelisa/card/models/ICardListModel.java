package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardListModel.class)
public interface ICardListModel {

	String getUserId();
	void setUserId(String userId);
	
	java.util.List<com.anfelisa.card.models.ICardModel> getCardList();
	void setCardList(java.util.List<com.anfelisa.card.models.ICardModel> cardList);
	
	String getCategoryId();
	void setCategoryId(String categoryId);
	
	
}

/*       S.D.G.       */
