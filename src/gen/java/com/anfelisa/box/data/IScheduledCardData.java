/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IScheduledCardModel;

@JsonDeserialize(as=ScheduledCardData.class)
public interface IScheduledCardData extends IScheduledCardModel, IDataContainer {
	
	IScheduledCardData withScheduledCardId(String scheduledCardId);
	
	IScheduledCardData withCardId(String cardId);
	
	IScheduledCardData withBoxId(String boxId);
	
	IScheduledCardData withCreatedDate(java.time.LocalDateTime createdDate);
	
	IScheduledCardData withEf(Float ef);
	
	IScheduledCardData withInterval(Integer interval);
	
	IScheduledCardData withN(Integer n);
	
	IScheduledCardData withCount(Integer count);
	
	IScheduledCardData withScheduledDate(java.time.LocalDateTime scheduledDate);
	
	IScheduledCardData withLastQuality(Integer lastQuality);
	
	IScheduledCardData withQuality(Integer quality);
	
	IScheduledCardData withScoredDate(java.time.LocalDateTime scoredDate);
	
	
}



/******* S.D.G. *******/



