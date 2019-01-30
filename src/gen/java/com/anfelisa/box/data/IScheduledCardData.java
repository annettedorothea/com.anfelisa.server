package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScheduledCardModel;

@JsonDeserialize(as=ScheduledCardData.class)
public interface IScheduledCardData extends IScheduledCardModel, IDataContainer {
	
	IScheduledCardData withScheduledCardId(String scheduledCardId);
	
	IScheduledCardData withCardId(String cardId);
	
	IScheduledCardData withBoxId(String boxId);
	
	IScheduledCardData withCreatedDate(org.joda.time.DateTime createdDate);
	
	IScheduledCardData withEf(Float ef);
	
	IScheduledCardData withInterval(Integer interval);
	
	IScheduledCardData withN(Integer n);
	
	IScheduledCardData withCount(Integer count);
	
	IScheduledCardData withScheduledDate(org.joda.time.DateTime scheduledDate);
	
	IScheduledCardData withLastQuality(Integer lastQuality);
	
	IScheduledCardData withQuality(Integer quality);
	
	IScheduledCardData withScoredDate(org.joda.time.DateTime scoredDate);
	
	
}

/*       S.D.G.       */
