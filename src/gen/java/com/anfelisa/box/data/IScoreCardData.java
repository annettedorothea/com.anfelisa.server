package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScoreCardModel;

@JsonDeserialize(as=ScoreCardData.class)
public interface IScoreCardData extends IScoreCardModel, IDataContainer {
	
	IScoreCardData withCardId(String cardId);
	
	IScoreCardData withNextScheduledCardScheduledCardId(String nextScheduledCardScheduledCardId);
	
	IScoreCardData withNextScheduledCardCreatedDate(org.joda.time.DateTime nextScheduledCardCreatedDate);
	
	IScoreCardData withNextScheduledCardEf(Float nextScheduledCardEf);
	
	IScoreCardData withNextScheduledCardInterval(Integer nextScheduledCardInterval);
	
	IScoreCardData withNextScheduledCardN(Integer nextScheduledCardN);
	
	IScoreCardData withNextScheduledCardCount(Integer nextScheduledCardCount);
	
	IScoreCardData withNextScheduledCardScheduledDate(org.joda.time.DateTime nextScheduledCardScheduledDate);
	
	IScoreCardData withNextScheduledCardLastQuality(Integer nextScheduledCardLastQuality);
	
	IScoreCardData withScoredCardScheduledCardId(String scoredCardScheduledCardId);
	
	IScoreCardData withScoredCardQuality(Integer scoredCardQuality);
	
	IScoreCardData withScoredCardScoredDate(org.joda.time.DateTime scoredCardScoredDate);
	
	IScoreCardData withReinforceCardId(String reinforceCardId);
	
	IScoreCardData withReinforceCardCreatedDate(org.joda.time.DateTime reinforceCardCreatedDate);
	
	IScoreCardData withUserId(String userId);
	
	IScoreCardData withBoxId(String boxId);
	
	
}

/*       S.D.G.       */
