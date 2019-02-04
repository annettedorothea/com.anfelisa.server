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
	
	org.joda.time.DateTime getNextScheduledCardCreatedDate();
	void setNextScheduledCardCreatedDate(org.joda.time.DateTime nextScheduledCardCreatedDate);
	
	Float getNextScheduledCardEf();
	void setNextScheduledCardEf(Float nextScheduledCardEf);
	
	Integer getNextScheduledCardInterval();
	void setNextScheduledCardInterval(Integer nextScheduledCardInterval);
	
	Integer getNextScheduledCardN();
	void setNextScheduledCardN(Integer nextScheduledCardN);
	
	Integer getNextScheduledCardCount();
	void setNextScheduledCardCount(Integer nextScheduledCardCount);
	
	org.joda.time.DateTime getNextScheduledCardScheduledDate();
	void setNextScheduledCardScheduledDate(org.joda.time.DateTime nextScheduledCardScheduledDate);
	
	Integer getNextScheduledCardLastQuality();
	void setNextScheduledCardLastQuality(Integer nextScheduledCardLastQuality);
	
	String getScoredCardScheduledCardId();
	void setScoredCardScheduledCardId(String scoredCardScheduledCardId);
	
	Integer getScoredCardQuality();
	void setScoredCardQuality(Integer scoredCardQuality);
	
	org.joda.time.DateTime getScoredCardScoredDate();
	void setScoredCardScoredDate(org.joda.time.DateTime scoredCardScoredDate);
	
	String getReinforceCardId();
	void setReinforceCardId(String reinforceCardId);
	
	org.joda.time.DateTime getReinforceCardCreatedDate();
	void setReinforceCardCreatedDate(org.joda.time.DateTime reinforceCardCreatedDate);
	
	String getUserId();
	void setUserId(String userId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	
	List<String> equalsPrimitiveTypes(IScoreCardModel other);
	
}

/*       S.D.G.       */
