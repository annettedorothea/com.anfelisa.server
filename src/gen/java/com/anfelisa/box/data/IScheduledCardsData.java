package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScheduledCardsModel;

@JsonDeserialize(as=ScheduledCardsData.class)
public interface IScheduledCardsData extends IScheduledCardsModel, IDataContainer {
	
	IScheduledCardsData withNewScheduledCards(java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards);
	
	IScheduledCardsData withExistingScheduledCardIds(java.util.List<String> existingScheduledCardIds);
	
	IScheduledCardsData withCardIds(java.util.List<String> cardIds);
	
	IScheduledCardsData withScheduledDate(org.joda.time.DateTime scheduledDate);
	
	IScheduledCardsData withUserId(String userId);
	
	IScheduledCardsData withBoxId(String boxId);
	
	
}

/*       S.D.G.       */
