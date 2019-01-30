package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardIdListModel;

@JsonDeserialize(as=CardIdListData.class)
public interface ICardIdListData extends ICardIdListModel, IDataContainer {
	
	ICardIdListData withCardIdList(java.util.List<String> cardIdList);
	
	ICardIdListData withCategoryId(String categoryId);
	
	ICardIdListData withUserId(String userId);
	
	ICardIdListData withMovedCards(java.util.List<com.anfelisa.card.models.ICardModel> movedCards);
	
	
}

/*       S.D.G.       */
