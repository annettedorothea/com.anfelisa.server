/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IScoreCardModel;

@JsonDeserialize(as=ScoreCardData.class)
public interface IScoreCardData extends IScoreCardModel, IDataContainer {
	
	IScoreCardData withCardId(String cardId);
	
	IScoreCardData withNextScheduledCardScheduledCardId(String nextScheduledCardScheduledCardId);
	
	IScoreCardData withNextScheduledCardCreatedDate(java.time.LocalDateTime nextScheduledCardCreatedDate);
	
	IScoreCardData withNextScheduledCardEf(Float nextScheduledCardEf);
	
	IScoreCardData withNextScheduledCardInterval(Integer nextScheduledCardInterval);
	
	IScoreCardData withNextScheduledCardN(Integer nextScheduledCardN);
	
	IScoreCardData withNextScheduledCardCount(Integer nextScheduledCardCount);
	
	IScoreCardData withNextScheduledCardScheduledDate(java.time.LocalDateTime nextScheduledCardScheduledDate);
	
	IScoreCardData withNextScheduledCardLastQuality(Integer nextScheduledCardLastQuality);
	
	IScoreCardData withScheduledCardId(String scheduledCardId);
	
	IScoreCardData withScoredCardQuality(Integer scoredCardQuality);
	
	IScoreCardData withScoredCardScoredDate(java.time.LocalDateTime scoredCardScoredDate);
	
	IScoreCardData withReinforceCardId(String reinforceCardId);
	
	IScoreCardData withReinforceCardCreatedDate(java.time.LocalDateTime reinforceCardCreatedDate);
	
	IScoreCardData withUserId(String userId);
	
	IScoreCardData withBoxId(String boxId);
	
	
	IScoreCardData deepCopy();
}



/******* S.D.G. *******/



