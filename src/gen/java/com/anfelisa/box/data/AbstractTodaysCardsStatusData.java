/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.ITodaysCardsStatusModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractTodaysCardsStatusData extends AbstractData implements ITodaysCardsStatusData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractTodaysCardsStatusData.class);
	
	private Integer openTodaysCards;
	
	private Integer allTodaysCards;
	

	public AbstractTodaysCardsStatusData(
		@JsonProperty("openTodaysCards") Integer openTodaysCards,
		@JsonProperty("allTodaysCards") Integer allTodaysCards
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.openTodaysCards = openTodaysCards;
		this.allTodaysCards = allTodaysCards;
	}

	public AbstractTodaysCardsStatusData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public Integer getOpenTodaysCards() {
		return this.openTodaysCards;
	}
	public void setOpenTodaysCards(Integer openTodaysCards) {
		this.openTodaysCards = openTodaysCards;
	}
	public ITodaysCardsStatusData withOpenTodaysCards(Integer openTodaysCards) {
		this.openTodaysCards = openTodaysCards;
		return this;
	}
	
	@JsonProperty
	public Integer getAllTodaysCards() {
		return this.allTodaysCards;
	}
	public void setAllTodaysCards(Integer allTodaysCards) {
		this.allTodaysCards = allTodaysCards;
	}
	public ITodaysCardsStatusData withAllTodaysCards(Integer allTodaysCards) {
		this.allTodaysCards = allTodaysCards;
		return this;
	}
	
	
	
	public ITodaysCardsStatusData deepCopy() {
		ITodaysCardsStatusData copy = new TodaysCardsStatusData(this.getUuid());
		copy.setOpenTodaysCards(this.getOpenTodaysCards());
		copy.setAllTodaysCards(this.getAllTodaysCards());
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



