/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IBoxWithStatisticsModel;

@JsonDeserialize(as=BoxWithStatisticsData.class)
public interface IBoxWithStatisticsData extends IBoxWithStatisticsModel, IDataContainer {
	void mapFrom(com.anfelisa.box.models.IBoxViewModel model);
	void mapFrom(com.anfelisa.box.models.IBoxStatisticsModel model);
	
	IBoxWithStatisticsData withOpenTodaysCards(Integer openTodaysCards);
	
	IBoxWithStatisticsData withCategoryName(String categoryName);
	
	IBoxWithStatisticsData withCategoryAuthor(String categoryAuthor);
	
	IBoxWithStatisticsData withCategoryId(String categoryId);
	
	IBoxWithStatisticsData withBoxId(String boxId);
	
	IBoxWithStatisticsData withShared(Boolean shared);
	
	IBoxWithStatisticsData withReverse(Boolean reverse);
	
	IBoxWithStatisticsData withEditable(Boolean editable);
	
	IBoxWithStatisticsData withArchived(Boolean archived);
	
	IBoxWithStatisticsData withQuality0Count(Integer quality0Count);
	
	IBoxWithStatisticsData withQuality1Count(Integer quality1Count);
	
	IBoxWithStatisticsData withQuality2Count(Integer quality2Count);
	
	IBoxWithStatisticsData withQuality3Count(Integer quality3Count);
	
	IBoxWithStatisticsData withQuality4Count(Integer quality4Count);
	
	IBoxWithStatisticsData withQuality5Count(Integer quality5Count);
	
	IBoxWithStatisticsData withCountsPerDayNextWeek(java.util.List<Integer> countsPerDayNextWeek);
	
	IBoxWithStatisticsData withMaxCardsPerDay(Integer maxCardsPerDay);
	
	
	IBoxWithStatisticsData deepCopy();
}



/******* S.D.G. *******/



