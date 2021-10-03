/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class LoadNextCardResponse implements ILoadNextCardResponse {
	
	private com.anfelisa.box.models.INextCardViewModel nextCard;
	
	private Integer allTodaysCards;
	
	private Integer openTodaysCards;
	
	private Boolean reverse = false;
	
	public LoadNextCardResponse() {
	}
	
	public LoadNextCardResponse(com.anfelisa.box.models.INextCardModel data) {
		nextCard = data.getNextCard();
		allTodaysCards = data.getAllTodaysCards();
		openTodaysCards = data.getOpenTodaysCards();
		reverse = data.getReverse();
	}
	
	@JsonProperty
	public com.anfelisa.box.models.INextCardViewModel getNextCard() {
		return this.nextCard;
	}
	
	@JsonProperty
	public Integer getAllTodaysCards() {
		return this.allTodaysCards;
	}
	
	@JsonProperty
	public Integer getOpenTodaysCards() {
		return this.openTodaysCards;
	}
	
	@JsonProperty
	public Boolean getReverse() {
		return this.reverse;
	}
	
}



/******* S.D.G. *******/



