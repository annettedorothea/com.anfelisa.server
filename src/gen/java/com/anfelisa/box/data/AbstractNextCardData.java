/********************************************************************************
 * generated by de.acegen 1.5.4
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
import com.anfelisa.box.models.INextCardModel;
import com.anfelisa.box.models.ITodaysCardsStatusModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractNextCardData extends AbstractData implements INextCardData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractNextCardData.class);
	
	private String userId;
	
	private String boxId;
	
	private java.time.LocalDateTime todayAtMidnightInUTC;
	
	private com.anfelisa.box.models.INextCardViewModel nextCard;
	
	private Boolean reverse = false;
	
	private Integer openTodaysCards;
	
	private Integer allTodaysCards;
	

	public AbstractNextCardData(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("todayAtMidnightInUTC") java.time.LocalDateTime todayAtMidnightInUTC,
		@JsonProperty("nextCard") com.anfelisa.box.models.INextCardViewModel nextCard,
		@JsonProperty("reverse") Boolean reverse,
		@JsonProperty("openTodaysCards") Integer openTodaysCards,
		@JsonProperty("allTodaysCards") Integer allTodaysCards
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.boxId = boxId;
		this.todayAtMidnightInUTC = todayAtMidnightInUTC;
		this.nextCard = nextCard;
		this.reverse = reverse;
		this.openTodaysCards = openTodaysCards;
		this.allTodaysCards = allTodaysCards;
	}

	public AbstractNextCardData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public INextCardData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public INextCardData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public java.time.LocalDateTime getTodayAtMidnightInUTC() {
		return this.todayAtMidnightInUTC;
	}
	public void setTodayAtMidnightInUTC(java.time.LocalDateTime todayAtMidnightInUTC) {
		this.todayAtMidnightInUTC = todayAtMidnightInUTC;
	}
	public INextCardData withTodayAtMidnightInUTC(java.time.LocalDateTime todayAtMidnightInUTC) {
		this.todayAtMidnightInUTC = todayAtMidnightInUTC;
		return this;
	}
	
	@JsonProperty
	public com.anfelisa.box.models.INextCardViewModel getNextCard() {
		return this.nextCard;
	}
	public void setNextCard(com.anfelisa.box.models.INextCardViewModel nextCard) {
		this.nextCard = nextCard;
	}
	public INextCardData withNextCard(com.anfelisa.box.models.INextCardViewModel nextCard) {
		this.nextCard = nextCard;
		return this;
	}
	
	@JsonProperty
	public Boolean getReverse() {
		return this.reverse;
	}
	public void setReverse(Boolean reverse) {
		this.reverse = reverse;
	}
	public INextCardData withReverse(Boolean reverse) {
		this.reverse = reverse;
		return this;
	}
	
	@JsonProperty
	public Integer getOpenTodaysCards() {
		return this.openTodaysCards;
	}
	public void setOpenTodaysCards(Integer openTodaysCards) {
		this.openTodaysCards = openTodaysCards;
	}
	public INextCardData withOpenTodaysCards(Integer openTodaysCards) {
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
	public INextCardData withAllTodaysCards(Integer allTodaysCards) {
		this.allTodaysCards = allTodaysCards;
		return this;
	}
	
	
	public void mapFrom(com.anfelisa.box.models.ITodaysCardsStatusModel model) {
		this.openTodaysCards = model.getOpenTodaysCards();
		this.allTodaysCards = model.getAllTodaysCards();
	}
	
	public INextCardData deepCopy() {
		INextCardData copy = new NextCardData(this.getUuid());
		copy.setUserId(this.getUserId());
		copy.setBoxId(this.getBoxId());
		copy.setTodayAtMidnightInUTC(this.getTodayAtMidnightInUTC());
		copy.setNextCard(this.getNextCard().deepCopy());
		copy.setReverse(this.getReverse());
		copy.setOpenTodaysCards(this.getOpenTodaysCards());
		copy.setAllTodaysCards(this.getAllTodaysCards());
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



