/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.card.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class CardUpdatePriorityModel implements ICardUpdatePriorityModel {

	private String cardId;

	private Integer priority;

	private String userId;


	public CardUpdatePriorityModel() {
	}

	public CardUpdatePriorityModel(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("priority") Integer priority,
		@JsonProperty("userId") String userId
	) {
		this.cardId = cardId;
		this.priority = priority;
		this.userId = userId;
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	@JsonProperty
	public Integer getPriority() {
		return this.priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	public ICardUpdatePriorityModel deepCopy() {
		ICardUpdatePriorityModel copy = new CardUpdatePriorityModel();
		copy.setCardId(this.getCardId());
		copy.setPriority(this.getPriority());
		copy.setUserId(this.getUserId());
		return copy;
	}

}



/******* S.D.G. *******/



