/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.card.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CardListModel.class)
public interface ICardListModel {

	String getUserId();
	void setUserId(String userId);
	
	java.util.List<com.anfelisa.card.models.ICardWithInfoModel> getCardList();
	void setCardList(java.util.List<com.anfelisa.card.models.ICardWithInfoModel> cardList);
	
	String getCategoryId();
	void setCategoryId(String categoryId);
	
	
}




/******* S.D.G. *******/



