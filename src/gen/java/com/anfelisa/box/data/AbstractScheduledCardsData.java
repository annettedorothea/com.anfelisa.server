/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.IScheduledCardsModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractScheduledCardsData extends AbstractData implements IScheduledCardsData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractScheduledCardsData.class);
	
	private java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards;
	
	private java.util.List<String> existingScheduledCardIds;
	
	private java.util.List<String> cardIds;
	
	private org.joda.time.DateTime scheduledDate;
	
	private String userId;
	
	@NotNull
	private String boxId;
	

	public AbstractScheduledCardsData(
		@JsonProperty("newScheduledCards") java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards,
		@JsonProperty("existingScheduledCardIds") java.util.List<String> existingScheduledCardIds,
		@JsonProperty("cardIds") java.util.List<String> cardIds,
		@JsonProperty("scheduledDate") org.joda.time.DateTime scheduledDate,
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.newScheduledCards = newScheduledCards;
		this.existingScheduledCardIds = existingScheduledCardIds;
		this.cardIds = cardIds;
		this.scheduledDate = scheduledDate;
		this.userId = userId;
		this.boxId = boxId;
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
		public org.joda.time.DateTime getScheduledDate() {
			return this.scheduledDate;
		}
	public void setScheduledDate(org.joda.time.DateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	public IScheduledCardsData withScheduledDate(org.joda.time.DateTime scheduledDate) {
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
	
	
	
}




/******* S.D.G. *******/



