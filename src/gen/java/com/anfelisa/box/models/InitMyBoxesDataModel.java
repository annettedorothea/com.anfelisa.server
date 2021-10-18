/********************************************************************************
 * generated by de.acegen 1.6.4
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
public class InitMyBoxesDataModel implements IInitMyBoxesDataModel {

	private String userId;

	private java.time.LocalDateTime todayAtMidnightInUTC;

	private java.util.List<com.anfelisa.box.models.IPostponeCardsModel> postponeCards;

	private java.util.List<String> outdatedReinforceCardsIds;


	public InitMyBoxesDataModel() {
	}

	public InitMyBoxesDataModel(
		@JsonProperty("userId") String userId,
		@JsonProperty("todayAtMidnightInUTC") java.time.LocalDateTime todayAtMidnightInUTC,
		@JsonProperty("postponeCards") java.util.List<com.anfelisa.box.models.IPostponeCardsModel> postponeCards,
		@JsonProperty("outdatedReinforceCardsIds") java.util.List<String> outdatedReinforceCardsIds
	) {
		this.userId = userId;
		this.todayAtMidnightInUTC = todayAtMidnightInUTC;
		this.postponeCards = postponeCards;
		this.outdatedReinforceCardsIds = outdatedReinforceCardsIds;
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IPostponeCardsModel> getPostponeCards() {
		return this.postponeCards;
	}
	public void setPostponeCards(java.util.List<com.anfelisa.box.models.IPostponeCardsModel> postponeCards) {
		this.postponeCards = postponeCards;
	}
	
	@JsonProperty
	public java.util.List<String> getOutdatedReinforceCardsIds() {
		return this.outdatedReinforceCardsIds;
	}
	public void setOutdatedReinforceCardsIds(java.util.List<String> outdatedReinforceCardsIds) {
		this.outdatedReinforceCardsIds = outdatedReinforceCardsIds;
	}
	

	public IInitMyBoxesDataModel deepCopy() {
		IInitMyBoxesDataModel copy = new InitMyBoxesDataModel();
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
		return copy;
	}

}



/******* S.D.G. *******/



