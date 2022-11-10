/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=NextCardModel.class)
public interface INextCardModel extends com.anfelisa.box.models.ITodaysCardsStatusModel{

	String getUserId();
	void setUserId(String userId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	String getBoxName();
	void setBoxName(String boxName);
	
	java.time.LocalDateTime getTodayAtMidnightInUTC();
	void setTodayAtMidnightInUTC(java.time.LocalDateTime todayAtMidnightInUTC);
	
	com.anfelisa.box.models.INextCardViewModel getNextCard();
	void setNextCard(com.anfelisa.box.models.INextCardViewModel nextCard);
	
	Boolean getReverse();
	void setReverse(Boolean reverse);
	
	
	INextCardModel deepCopy();
}




/******* S.D.G. *******/



