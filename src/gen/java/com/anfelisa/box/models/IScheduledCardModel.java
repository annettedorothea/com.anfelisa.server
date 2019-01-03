package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScheduledCardModel.class)
public interface IScheduledCardModel {

	String getScheduledCardId();
	void setScheduledCardId(String scheduledCardId);
	
	String getCardId();
	void setCardId(String cardId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	org.joda.time.DateTime getCreatedDate();
	void setCreatedDate(org.joda.time.DateTime createdDate);
	
	Float getEf();
	void setEf(Float ef);
	
	Integer getInterval();
	void setInterval(Integer interval);
	
	Integer getN();
	void setN(Integer n);
	
	Integer getCount();
	void setCount(Integer count);
	
	org.joda.time.DateTime getScheduledDate();
	void setScheduledDate(org.joda.time.DateTime scheduledDate);
	
	Integer getLastQuality();
	void setLastQuality(Integer lastQuality);
	
	Integer getQuality();
	void setQuality(Integer quality);
	
	org.joda.time.DateTime getScoredDate();
	void setScoredDate(org.joda.time.DateTime scoredDate);
	

}

/*       S.D.G.       */
