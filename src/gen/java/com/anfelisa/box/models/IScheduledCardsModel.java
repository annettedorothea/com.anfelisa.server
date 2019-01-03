package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScheduledCardsModel.class)
public interface IScheduledCardsModel {

	java.util.List<com.anfelisa.box.models.IScheduledCardModel> getNewScheduledCards();
	void setNewScheduledCards(java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards);
	
	java.util.List<String> getExistingScheduledCardIds();
	void setExistingScheduledCardIds(java.util.List<String> existingScheduledCardIds);
	
	java.util.List<String> getCardIds();
	void setCardIds(java.util.List<String> cardIds);
	
	org.joda.time.DateTime getScheduledDate();
	void setScheduledDate(org.joda.time.DateTime scheduledDate);
	
	String getUserId();
	void setUserId(String userId);
	
	String getBoxId();
	void setBoxId(String boxId);
	

}

/*       S.D.G.       */
