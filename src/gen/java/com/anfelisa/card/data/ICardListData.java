/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.card.models.ICardListModel;

@JsonDeserialize(as=CardListData.class)
public interface ICardListData extends ICardListModel, IDataContainer {
	
	ICardListData withUserId(String userId);
	
	ICardListData withCardList(java.util.List<com.anfelisa.card.models.ICardWithInfoModel> cardList);
	
	ICardListData withCategoryId(String categoryId);
	
	ICardListData withFilterNonScheduled(Boolean filterNonScheduled);
	
	ICardListData withPriority(Integer priority);
	
	ICardListData withReverse(Boolean reverse);
	
	
}



/******* S.D.G. *******/



