/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ScoreCardModel.class)
public interface IScoreCardModel {

	String getCardId();
	void setCardId(String cardId);
	
	String getNextScheduledCardScheduledCardId();
	void setNextScheduledCardScheduledCardId(String nextScheduledCardScheduledCardId);
	
	java.time.LocalDateTime getNextScheduledCardCreatedDate();
	void setNextScheduledCardCreatedDate(java.time.LocalDateTime nextScheduledCardCreatedDate);
	
	Float getNextScheduledCardEf();
	void setNextScheduledCardEf(Float nextScheduledCardEf);
	
	Integer getNextScheduledCardInterval();
	void setNextScheduledCardInterval(Integer nextScheduledCardInterval);
	
	Integer getNextScheduledCardN();
	void setNextScheduledCardN(Integer nextScheduledCardN);
	
	Integer getNextScheduledCardCount();
	void setNextScheduledCardCount(Integer nextScheduledCardCount);
	
	java.time.LocalDateTime getNextScheduledCardScheduledDate();
	void setNextScheduledCardScheduledDate(java.time.LocalDateTime nextScheduledCardScheduledDate);
	
	Integer getNextScheduledCardLastQuality();
	void setNextScheduledCardLastQuality(Integer nextScheduledCardLastQuality);
	
	String getScheduledCardId();
	void setScheduledCardId(String scheduledCardId);
	
	Integer getScoredCardQuality();
	void setScoredCardQuality(Integer scoredCardQuality);
	
	java.time.LocalDateTime getScoredCardScoredDate();
	void setScoredCardScoredDate(java.time.LocalDateTime scoredCardScoredDate);
	
	String getReinforceCardId();
	void setReinforceCardId(String reinforceCardId);
	
	java.time.LocalDateTime getReinforceCardCreatedDate();
	void setReinforceCardCreatedDate(java.time.LocalDateTime reinforceCardCreatedDate);
	
	String getUserId();
	void setUserId(String userId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	Integer getIntervalDifference();
	void setIntervalDifference(Integer intervalDifference);
	
	
	IScoreCardModel deepCopy();
}




/******* S.D.G. *******/



