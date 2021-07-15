/********************************************************************************
 * generated by de.acegen 1.3.0
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
import com.anfelisa.box.models.IScheduledCardsModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractScheduledCardsData extends AbstractData implements IScheduledCardsData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractScheduledCardsData.class);
	
	private java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards;
	
	private java.util.List<String> existingScheduledCardIds;
	
	private java.util.List<String> cardIds;
	
	private java.time.LocalDateTime scheduledDate;
	
	private String userId;
	
	private String boxId;
	
	private Boolean reverse = false;
	

	public AbstractScheduledCardsData(
		@JsonProperty("newScheduledCards") java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards,
		@JsonProperty("existingScheduledCardIds") java.util.List<String> existingScheduledCardIds,
		@JsonProperty("cardIds") java.util.List<String> cardIds,
		@JsonProperty("scheduledDate") java.time.LocalDateTime scheduledDate,
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("reverse") Boolean reverse
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.newScheduledCards = newScheduledCards;
		this.existingScheduledCardIds = existingScheduledCardIds;
		this.cardIds = cardIds;
		this.scheduledDate = scheduledDate;
		this.userId = userId;
		this.boxId = boxId;
		this.reverse = reverse;
	}

	public AbstractScheduledCardsData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IScheduledCardModel> getNewScheduledCards() {
		return this.newScheduledCards;
	}
	public void setNewScheduledCards(java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards) {
		this.newScheduledCards = newScheduledCards;
	}
	public IScheduledCardsData withNewScheduledCards(java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards) {
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
	public IScheduledCardsData withExistingScheduledCardIds(java.util.List<String> existingScheduledCardIds) {
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
	public IScheduledCardsData withCardIds(java.util.List<String> cardIds) {
		this.cardIds = cardIds;
		return this;
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
	public IScheduledCardsData withScheduledDate(java.time.LocalDateTime scheduledDate) {
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
	public IScheduledCardsData withUserId(String userId) {
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
	public IScheduledCardsData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public Boolean getReverse() {
		return this.reverse;
	}
	public void setReverse(Boolean reverse) {
		this.reverse = reverse;
	}
	public IScheduledCardsData withReverse(Boolean reverse) {
		this.reverse = reverse;
		return this;
	}
	
	
	
	public IScheduledCardsData deepCopy() {
		IScheduledCardsData copy = new ScheduledCardsData(this.getUuid());
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
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



