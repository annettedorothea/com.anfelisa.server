package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardListModel;

@JsonDeserialize(as=CardListData.class)
public interface ICardListData extends ICardListModel, IDataContainer {
	
	ICardListData withUserId(String userId);
	
	ICardListData withCardList(java.util.List<com.anfelisa.card.models.ICardModel> cardList);
	
	ICardListData withCategoryId(String categoryId);
	
	
}

/*       S.D.G.       */
