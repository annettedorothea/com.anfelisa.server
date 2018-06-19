package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScheduledCardsModel;
import com.anfelisa.box.models.IUserIdModel;
import com.anfelisa.box.models.IBoxIdModel;

@SuppressWarnings("all")
public class ScheduleCardsPresentationalData implements IScheduleCardsPresentationalData {
	
	private java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards;
	
	private java.util.List<String> existingScheduledCardIds;
	
	private java.util.List<String> cardIds;
	
	private org.joda.time.DateTime scheduledDate;
	
	@NotNull
	private String userId;
	
	@NotNull
	private String boxId;
	
	
	public ScheduleCardsPresentationalData(
		@JsonProperty("newScheduledCards") java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards,
		@JsonProperty("existingScheduledCardIds") java.util.List<String> existingScheduledCardIds,
		@JsonProperty("cardIds") java.util.List<String> cardIds,
		@JsonProperty("scheduledDate") org.joda.time.DateTime scheduledDate,
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId
	) {
		this.newScheduledCards = newScheduledCards;
		this.existingScheduledCardIds = existingScheduledCardIds;
		this.cardIds = cardIds;
		this.scheduledDate = scheduledDate;
		this.userId = userId;
		this.boxId = boxId;
		
	}

	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IScheduledCardModel> getNewScheduledCards() {
		return this.newScheduledCards;
	}
	public void setNewScheduledCards(java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards) {
		this.newScheduledCards = newScheduledCards;
	}
	public ScheduleCardsPresentationalData withNewScheduledCards(java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards) {
		this.newScheduledCards = newScheduledCards;
		return this;
	}
	
	@JsonProperty
	public java.util.List<String> getExistingScheduledCardIds() {
		return this.existingScheduledCardIds;
	}
	public void setExistingScheduledCardIds(java.util.List<String> existingScheduledCardIds) {
		this.existingScheduledCardIds = existingScheduledCardIds;
	}
	public ScheduleCardsPresentationalData withExistingScheduledCardIds(java.util.List<String> existingScheduledCardIds) {
		this.existingScheduledCardIds = existingScheduledCardIds;
		return this;
	}
	
	@JsonProperty
	public java.util.List<String> getCardIds() {
		return this.cardIds;
	}
	public void setCardIds(java.util.List<String> cardIds) {
		this.cardIds = cardIds;
	}
	public ScheduleCardsPresentationalData withCardIds(java.util.List<String> cardIds) {
		this.cardIds = cardIds;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getScheduledDate() {
		return this.scheduledDate;
	}
	public void setScheduledDate(org.joda.time.DateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	public ScheduleCardsPresentationalData withScheduledDate(org.joda.time.DateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ScheduleCardsPresentationalData withUserId(String userId) {
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
	public ScheduleCardsPresentationalData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
}

/*       S.D.G.       */
