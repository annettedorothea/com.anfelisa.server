/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=TodaysCardsStatusModel.class)
public interface ITodaysCardsStatusModel {

	Integer getOpenTodaysCards();
	void setOpenTodaysCards(Integer openTodaysCards);
	
	Integer getAllTodaysCards();
	void setAllTodaysCards(Integer allTodaysCards);
	
	
	ITodaysCardsStatusModel deepCopy();
}




/******* S.D.G. *******/



