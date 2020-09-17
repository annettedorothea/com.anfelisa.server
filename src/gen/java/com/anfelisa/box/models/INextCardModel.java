/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=NextCardModel.class)
public interface INextCardModel extends com.anfelisa.box.models.INextCardViewModel,com.anfelisa.box.models.ITodaysCardsStatusModel{

	String getUserId();
	void setUserId(String userId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	java.time.LocalDateTime getTodayAtMidnightInUTC();
	void setTodayAtMidnightInUTC(java.time.LocalDateTime todayAtMidnightInUTC);
	
	Integer getOpenTodaysCards();
	void setOpenTodaysCards(Integer openTodaysCards);
	
	Integer getAllTodaysCards();
	void setAllTodaysCards(Integer allTodaysCards);
	
	
}




/******* S.D.G. *******/



