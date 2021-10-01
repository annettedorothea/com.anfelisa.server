/********************************************************************************
 * generated by de.acegen
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
public class ScheduledCardsModel implements IScheduledCardsModel {

	private java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards;

	private java.util.List<String> existingScheduledCardIds;

	private java.util.List<String> cardIds;

	private java.time.LocalDateTime scheduledDate;

	private String userId;

	private String boxId;

	private Boolean reverse = false;


	public ScheduledCardsModel() {
	}

	public ScheduledCardsModel(
		@JsonProperty("newScheduledCards") java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards,
		@JsonProperty("existingScheduledCardIds") java.util.List<String> existingScheduledCardIds,
		@JsonProperty("cardIds") java.util.List<String> cardIds,
		@JsonProperty("scheduledDate") java.time.LocalDateTime scheduledDate,
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("reverse") Boolean reverse
	) {
		this.newScheduledCards = newScheduledCards;
		this.existingScheduledCardIds = existingScheduledCardIds;
		this.cardIds = cardIds;
		this.scheduledDate = scheduledDate;
		this.userId = userId;
		this.boxId = boxId;
		this.reverse = reverse;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IScheduledCardModel> getNewScheduledCards() {
		return this.newScheduledCards;
	}
	public void setNewScheduledCards(java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards) {
		this.newScheduledCards = newScheduledCards;
	}
	
	@JsonProperty
	public java.util.List<String> getExistingScheduledCardIds() {
		return this.existingScheduledCardIds;
	}
	public void setExistingScheduledCardIds(java.util.List<String> existingScheduledCardIds) {
		this.existingScheduledCardIds = existingScheduledCardIds;
	}
	
	@JsonProperty
	public java.util.List<String> getCardIds() {
		return this.cardIds;
	}
	public void setCardIds(java.util.List<String> cardIds) {
		this.cardIds = cardIds;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public java.time.LocalDateTime getScheduledDate() {
		return this.scheduledDate;
	}
	public void setScheduledDate(java.time.LocalDateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
	public Boolean getReverse() {
		return this.reverse;
	}
	public void setReverse(Boolean reverse) {
		this.reverse = reverse;
	}
	

	public IScheduledCardsModel deepCopy() {
		IScheduledCardsModel copy = new ScheduledCardsModel();
		List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCardsCopy = new ArrayList<com.anfelisa.box.models.IScheduledCardModel>();
		for(com.anfelisa.box.models.IScheduledCardModel item: this.getNewScheduledCards()) {
			newScheduledCardsCopy.add(item.deepCopy());
		}
		copy.setNewScheduledCards(newScheduledCardsCopy);
		List<String> existingScheduledCardIdsCopy = new ArrayList<String>();
		for(String item: this.getExistingScheduledCardIds()) {
			existingScheduledCardIdsCopy.add(item);
		}
		copy.setExistingScheduledCardIds(existingScheduledCardIdsCopy);
		List<String> cardIdsCopy = new ArrayList<String>();
		for(String item: this.getCardIds()) {
			cardIdsCopy.add(item);
		}
		copy.setCardIds(cardIdsCopy);
		copy.setScheduledDate(this.getScheduledDate());
		copy.setUserId(this.getUserId());
		copy.setBoxId(this.getBoxId());
		copy.setReverse(this.getReverse());
		return copy;
	}

}



/******* S.D.G. *******/



