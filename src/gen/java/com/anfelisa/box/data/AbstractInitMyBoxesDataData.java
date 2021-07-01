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
import com.anfelisa.box.models.IInitMyBoxesDataModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractInitMyBoxesDataData extends AbstractData implements IInitMyBoxesDataData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractInitMyBoxesDataData.class);
	
	private String userId;
	
	private java.time.LocalDateTime todayAtMidnightInUTC;
	
	private java.util.List<com.anfelisa.box.models.IPostponeCardsModel> postponeCards;
	
	private java.util.List<String> outdatedReinforceCardsIds;
	

	public AbstractInitMyBoxesDataData(
		@JsonProperty("userId") String userId,
		@JsonProperty("todayAtMidnightInUTC") java.time.LocalDateTime todayAtMidnightInUTC,
		@JsonProperty("postponeCards") java.util.List<com.anfelisa.box.models.IPostponeCardsModel> postponeCards,
		@JsonProperty("outdatedReinforceCardsIds") java.util.List<String> outdatedReinforceCardsIds
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.todayAtMidnightInUTC = todayAtMidnightInUTC;
		this.postponeCards = postponeCards;
		this.outdatedReinforceCardsIds = outdatedReinforceCardsIds;
	}

	public AbstractInitMyBoxesDataData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IInitMyBoxesDataData withUserId(String userId) {
		this.userId = userId;
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
	public IInitMyBoxesDataData withTodayAtMidnightInUTC(java.time.LocalDateTime todayAtMidnightInUTC) {
		this.todayAtMidnightInUTC = todayAtMidnightInUTC;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IPostponeCardsModel> getPostponeCards() {
		return this.postponeCards;
	}
	public void setPostponeCards(java.util.List<com.anfelisa.box.models.IPostponeCardsModel> postponeCards) {
		this.postponeCards = postponeCards;
	}
	public IInitMyBoxesDataData withPostponeCards(java.util.List<com.anfelisa.box.models.IPostponeCardsModel> postponeCards) {
		this.postponeCards = postponeCards;
		return this;
	}
	
	@JsonProperty
	public java.util.List<String> getOutdatedReinforceCardsIds() {
		return this.outdatedReinforceCardsIds;
	}
	public void setOutdatedReinforceCardsIds(java.util.List<String> outdatedReinforceCardsIds) {
		this.outdatedReinforceCardsIds = outdatedReinforceCardsIds;
	}
	public IInitMyBoxesDataData withOutdatedReinforceCardsIds(java.util.List<String> outdatedReinforceCardsIds) {
		this.outdatedReinforceCardsIds = outdatedReinforceCardsIds;
		return this;
	}
	
	
	
	public IInitMyBoxesDataData deepCopy() {
		IInitMyBoxesDataData copy = new InitMyBoxesDataData(this.getUuid());
		copy.setUserId(this.getUserId());
		copy.setTodayAtMidnightInUTC(this.getTodayAtMidnightInUTC());
		List<com.anfelisa.box.models.IPostponeCardsModel> postponeCardsCopy = new ArrayList<com.anfelisa.box.models.IPostponeCardsModel>();
		for(com.anfelisa.box.models.IPostponeCardsModel item: this.getPostponeCards()) {
			postponeCardsCopy.add(item.deepCopy());
		}
		copy.setPostponeCards(postponeCardsCopy);
		List<String> outdatedReinforceCardsIdsCopy = new ArrayList<String>();
		for(String item: this.getOutdatedReinforceCardsIds()) {
			outdatedReinforceCardsIdsCopy.add(item);
		}
		copy.setOutdatedReinforceCardsIds(outdatedReinforceCardsIdsCopy);
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



