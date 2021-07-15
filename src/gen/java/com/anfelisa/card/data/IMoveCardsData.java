/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.card.models.IMoveCardsModel;

@JsonDeserialize(as=MoveCardsData.class)
public interface IMoveCardsData extends IMoveCardsModel, IDataContainer {
	
	IMoveCardsData withCardIdList(java.util.List<String> cardIdList);
	
	IMoveCardsData withCategoryId(String categoryId);
	
	IMoveCardsData withUserId(String userId);
	
	IMoveCardsData withMovedCards(java.util.List<com.anfelisa.card.models.ICardModel> movedCards);
	
	IMoveCardsData withUpdatedIndices(java.util.List<com.anfelisa.card.models.ICardModel> updatedIndices);
	
	
	IMoveCardsData deepCopy();
}



/******* S.D.G. *******/



