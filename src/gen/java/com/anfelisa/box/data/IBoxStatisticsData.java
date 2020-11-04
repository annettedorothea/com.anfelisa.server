/********************************************************************************
 * generated by de.acegen 1.0.1
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IBoxStatisticsModel;

@JsonDeserialize(as=BoxStatisticsData.class)
public interface IBoxStatisticsData extends IBoxStatisticsModel, IDataContainer {
	
	IBoxStatisticsData withBoxId(String boxId);
	
	IBoxStatisticsData withQuality0Count(Integer quality0Count);
	
	IBoxStatisticsData withQuality1Count(Integer quality1Count);
	
	IBoxStatisticsData withQuality2Count(Integer quality2Count);
	
	IBoxStatisticsData withQuality3Count(Integer quality3Count);
	
	IBoxStatisticsData withQuality4Count(Integer quality4Count);
	
	IBoxStatisticsData withQuality5Count(Integer quality5Count);
	
	IBoxStatisticsData withCountsPerDayNextWeek(java.util.List<Integer> countsPerDayNextWeek);
	
	IBoxStatisticsData withMaxCardsPerDay(Integer maxCardsPerDay);
	
	
}



/******* S.D.G. *******/



