/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=SortCardsOutModel.class)
public interface ISortCardsOutModel {

	java.util.List<String> getSortedOutScheduledCardIds();
	void setSortedOutScheduledCardIds(java.util.List<String> sortedOutScheduledCardIds);
	
	java.util.List<String> getSortedOutReinforceCardIds();
	void setSortedOutReinforceCardIds(java.util.List<String> sortedOutReinforceCardIds);
	
	java.util.List<String> getCardIds();
	void setCardIds(java.util.List<String> cardIds);
	
	String getUserId();
	void setUserId(String userId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	
}




/******* S.D.G. *******/



