package com.anfelisa.card.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CardSearchModel.class)
public interface ICardSearchModel {

	String getGiven();
	void setGiven(String given);
	
	String getWanted();
	void setWanted(String wanted);
	
	String getCategoryId();
	void setCategoryId(String categoryId);
	
	java.util.List<com.anfelisa.card.models.ICardWithCategoryNameModel> getCardList();
	void setCardList(java.util.List<com.anfelisa.card.models.ICardWithCategoryNameModel> cardList);
	
	Boolean getNaturalInputOrder();
	void setNaturalInputOrder(Boolean naturalInputOrder);
	
	
	List<String> equalsPrimitiveTypes(ICardSearchModel other);
	
}

/*       S.D.G.       */
