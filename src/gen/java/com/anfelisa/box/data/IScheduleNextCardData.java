package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScheduleNextCardModel;

@JsonDeserialize(as=ScheduleNextCardData.class)
public interface IScheduleNextCardData extends IScheduleNextCardModel, IDataContainer {
	void mapFrom(com.anfelisa.box.models.IScheduledCardModel model);
	
	IScheduleNextCardData withUserId(String userId);
	
	IScheduleNextCardData withBoxId(String boxId);
	
	IScheduleNextCardData withScheduledCardId(String scheduledCardId);
	
	IScheduleNextCardData withCardId(String cardId);
	
	IScheduleNextCardData withCreatedDate(org.joda.time.DateTime createdDate);
	
	IScheduleNextCardData withEf(Float ef);
	
	IScheduleNextCardData withInterval(Integer interval);
	
	IScheduleNextCardData withN(Integer n);
	
	IScheduleNextCardData withCount(Integer count);
	
	IScheduleNextCardData withScheduledDate(org.joda.time.DateTime scheduledDate);
	
	IScheduleNextCardData withLastQuality(Integer lastQuality);
	
	IScheduleNextCardData withQuality(Integer quality);
	
	IScheduleNextCardData withScoredDate(org.joda.time.DateTime scoredDate);
	
	
}

/*       S.D.G.       */
