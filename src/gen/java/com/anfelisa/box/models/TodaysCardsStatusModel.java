/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class TodaysCardsStatusModel implements ITodaysCardsStatusModel {

	private Integer openTodaysCards;

	private Integer allTodaysCards;


	public TodaysCardsStatusModel() {
	}

	public TodaysCardsStatusModel(
		@JsonProperty("openTodaysCards") Integer openTodaysCards,
		@JsonProperty("allTodaysCards") Integer allTodaysCards
	) {
		this.openTodaysCards = openTodaysCards;
		this.allTodaysCards = allTodaysCards;
	}

	@JsonProperty
	public Integer getOpenTodaysCards() {
		return this.openTodaysCards;
	}
	public void setOpenTodaysCards(Integer openTodaysCards) {
		this.openTodaysCards = openTodaysCards;
	}
	
	@JsonProperty
	public Integer getAllTodaysCards() {
		return this.allTodaysCards;
	}
	public void setAllTodaysCards(Integer allTodaysCards) {
		this.allTodaysCards = allTodaysCards;
	}
	

}



/******* S.D.G. *******/



