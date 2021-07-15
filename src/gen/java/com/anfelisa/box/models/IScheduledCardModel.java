/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ScheduledCardModel.class)
public interface IScheduledCardModel {

	String getScheduledCardId();
	void setScheduledCardId(String scheduledCardId);
	
	String getCardId();
	void setCardId(String cardId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	java.time.LocalDateTime getCreatedDate();
	void setCreatedDate(java.time.LocalDateTime createdDate);
	
	Float getEf();
	void setEf(Float ef);
	
	Integer getInterval();
	void setInterval(Integer interval);
	
	Integer getN();
	void setN(Integer n);
	
	Integer getCount();
	void setCount(Integer count);
	
	java.time.LocalDateTime getScheduledDate();
	void setScheduledDate(java.time.LocalDateTime scheduledDate);
	
	Integer getLastQuality();
	void setLastQuality(Integer lastQuality);
	
	Integer getQuality();
	void setQuality(Integer quality);
	
	java.time.LocalDateTime getScoredDate();
	void setScoredDate(java.time.LocalDateTime scoredDate);
	
	
	IScheduledCardModel deepCopy();
}




/******* S.D.G. *******/



