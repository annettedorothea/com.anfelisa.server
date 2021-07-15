/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=InitMyBoxesDataModel.class)
public interface IInitMyBoxesDataModel {

	String getUserId();
	void setUserId(String userId);
	
	java.time.LocalDateTime getTodayAtMidnightInUTC();
	void setTodayAtMidnightInUTC(java.time.LocalDateTime todayAtMidnightInUTC);
	
	java.util.List<com.anfelisa.box.models.IPostponeCardsModel> getPostponeCards();
	void setPostponeCards(java.util.List<com.anfelisa.box.models.IPostponeCardsModel> postponeCards);
	
	java.util.List<String> getOutdatedReinforceCardsIds();
	void setOutdatedReinforceCardsIds(java.util.List<String> outdatedReinforceCardsIds);
	
	
	IInitMyBoxesDataModel deepCopy();
}




/******* S.D.G. *******/



