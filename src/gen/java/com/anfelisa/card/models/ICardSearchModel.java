package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardSearchModel.class)
public interface ICardSearchModel {

	String getGiven();
	void setGiven(String given);
	
	String getWanted();
	void setWanted(String wanted);
	
	String getCategoryId();
	void setCategoryId(String categoryId);
	
	java.util.List<com.anfelisa.card.models.ICardModel> getCardList();
	void setCardList(java.util.List<com.anfelisa.card.models.ICardModel> cardList);
	
	Boolean getNaturalInputOrder();
	void setNaturalInputOrder(Boolean naturalInputOrder);
	

}

/*       S.D.G.       */
