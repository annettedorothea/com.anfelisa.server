/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ScheduledCardsModel.class)
public interface IScheduledCardsModel {

	java.util.List<com.anfelisa.box.models.IScheduledCardModel> getNewScheduledCards();
	void setNewScheduledCards(java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards);
	
	java.util.List<String> getExistingScheduledCardIds();
	void setExistingScheduledCardIds(java.util.List<String> existingScheduledCardIds);
	
	java.util.List<String> getCardIds();
	void setCardIds(java.util.List<String> cardIds);
	
	java.time.LocalDateTime getScheduledDate();
	void setScheduledDate(java.time.LocalDateTime scheduledDate);
	
	String getUserId();
	void setUserId(String userId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	Boolean getReverse();
	void setReverse(Boolean reverse);
	
	
	IScheduledCardsModel deepCopy();
}




/******* S.D.G. *******/



