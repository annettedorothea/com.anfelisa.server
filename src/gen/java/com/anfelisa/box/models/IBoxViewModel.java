package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxViewModel.class)
public interface IBoxViewModel {

	Integer getTodaysCards();
	void setTodaysCards(Integer todaysCards);
	
	Integer getTotalCards();
	void setTotalCards(Integer totalCards);
	
	Integer getReinforceCards();
	void setReinforceCards(Integer reinforceCards);
	
	Integer getMyCards();
	void setMyCards(Integer myCards);
	
	Integer getDaysBehindSchedule();
	void setDaysBehindSchedule(Integer daysBehindSchedule);
	
	String getCategoryName();
	void setCategoryName(String categoryName);
	
	Integer getMaxInterval();
	void setMaxInterval(Integer maxInterval);
	
	Integer getMaxCardsPerDay();
	void setMaxCardsPerDay(Integer maxCardsPerDay);
	
	Integer getQuality0Count();
	void setQuality0Count(Integer quality0Count);
	
	Integer getQuality1Count();
	void setQuality1Count(Integer quality1Count);
	
	Integer getQuality2Count();
	void setQuality2Count(Integer quality2Count);
	
	Integer getQuality3Count();
	void setQuality3Count(Integer quality3Count);
	
	Integer getQuality4Count();
	void setQuality4Count(Integer quality4Count);
	
	Integer getQuality5Count();
	void setQuality5Count(Integer quality5Count);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	
}

/*       S.D.G.       */
