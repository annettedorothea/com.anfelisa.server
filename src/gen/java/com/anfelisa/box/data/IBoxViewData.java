package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxViewModel;

@JsonDeserialize(as=BoxViewData.class)
public interface IBoxViewData extends IBoxViewModel, IDataContainer {
	
	IBoxViewData withTodaysCards(Integer todaysCards);
	
	IBoxViewData withTotalCards(Integer totalCards);
	
	IBoxViewData withReinforceCards(Integer reinforceCards);
	
	IBoxViewData withMyCards(Integer myCards);
	
	IBoxViewData withDaysBehindSchedule(Integer daysBehindSchedule);
	
	IBoxViewData withCategoryName(String categoryName);
	
	IBoxViewData withMaxInterval(Integer maxInterval);
	
	IBoxViewData withMaxCardsPerDay(Integer maxCardsPerDay);
	
	IBoxViewData withQuality0Count(Integer quality0Count);
	
	IBoxViewData withQuality1Count(Integer quality1Count);
	
	IBoxViewData withQuality2Count(Integer quality2Count);
	
	IBoxViewData withQuality3Count(Integer quality3Count);
	
	IBoxViewData withQuality4Count(Integer quality4Count);
	
	IBoxViewData withQuality5Count(Integer quality5Count);
	
	IBoxViewData withBoxId(String boxId);
	
	
}

/*       S.D.G.       */
