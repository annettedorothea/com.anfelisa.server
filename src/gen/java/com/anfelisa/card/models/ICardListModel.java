package com.anfelisa.card.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CardListModel.class)
public interface ICardListModel {

	String getUserId();
	void setUserId(String userId);
	
	java.util.List<com.anfelisa.card.models.ICardModel> getCardList();
	void setCardList(java.util.List<com.anfelisa.card.models.ICardModel> cardList);
	
	String getCategoryId();
	void setCategoryId(String categoryId);
	
	
	List<String> equalsPrimitiveTypes(ICardListModel other);
	
}

/*       S.D.G.       */
