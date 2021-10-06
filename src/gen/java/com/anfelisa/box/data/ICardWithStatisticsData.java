/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.ICardWithStatisticsModel;

@JsonDeserialize(as=CardWithStatisticsData.class)
public interface ICardWithStatisticsData extends ICardWithStatisticsModel, IDataContainer {
	void mapFrom(com.anfelisa.card.models.ICardWithInfoModel model);
	
	ICardWithStatisticsData withEf(Float ef);
	
	ICardWithStatisticsData withInterval(Integer interval);
	
	ICardWithStatisticsData withCount(Integer count);
	
	ICardWithStatisticsData withLastQuality(Integer lastQuality);
	
	ICardWithStatisticsData withNext(java.time.LocalDateTime next);
	
	ICardWithStatisticsData withCardId(String cardId);
	
	ICardWithStatisticsData withGiven(String given);
	
	ICardWithStatisticsData withWanted(String wanted);
	
	ICardWithStatisticsData withCardAuthor(String cardAuthor);
	
	ICardWithStatisticsData withCardIndex(Integer cardIndex);
	
	ICardWithStatisticsData withCategoryId(String categoryId);
	
	ICardWithStatisticsData withRootCategoryId(String rootCategoryId);
	
	ICardWithStatisticsData withPriority(Integer priority);
	
	
	ICardWithStatisticsData deepCopy();
}



/******* S.D.G. *******/



