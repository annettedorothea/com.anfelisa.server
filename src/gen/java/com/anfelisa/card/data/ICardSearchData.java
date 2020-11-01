/********************************************************************************
 * generated by de.acegen 1.0.1
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.card.models.ICardSearchModel;

@JsonDeserialize(as=CardSearchData.class)
public interface ICardSearchData extends ICardSearchModel, IDataContainer {
	
	ICardSearchData withUserId(String userId);
	
	ICardSearchData withGiven(String given);
	
	ICardSearchData withWanted(String wanted);
	
	ICardSearchData withCategoryId(String categoryId);
	
	ICardSearchData withCardList(java.util.List<com.anfelisa.card.models.ICardWithCategoryNameModel> cardList);
	
	ICardSearchData withNaturalInputOrder(Boolean naturalInputOrder);
	
	
}



/******* S.D.G. *******/



