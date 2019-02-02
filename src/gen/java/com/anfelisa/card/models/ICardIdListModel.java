package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardIdListModel.class)
public interface ICardIdListModel {

	java.util.List<String> getCardIdList();
	void setCardIdList(java.util.List<String> cardIdList);
	
	String getCategoryId();
	void setCategoryId(String categoryId);
	
	String getUserId();
	void setUserId(String userId);
	
	java.util.List<com.anfelisa.card.models.ICardModel> getMovedCards();
	void setMovedCards(java.util.List<com.anfelisa.card.models.ICardModel> movedCards);
	
	
}

/*       S.D.G.       */
