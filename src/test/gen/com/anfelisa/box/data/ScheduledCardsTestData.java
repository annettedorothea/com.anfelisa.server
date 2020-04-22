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

import org.joda.time.DateTime;
import java.util.List;

@SuppressWarnings("unused")
public class ScheduledCardsTestData {
	
	private String uuid;

	private java.util.List<com.anfelisa.box.data.ScheduledCardTestData> newScheduledCards;
	
	private java.util.List<String> existingScheduledCardIds;
	
	private java.util.List<String> cardIds;
	
	private String scheduledDate;
	
	private String userId;
	
	private String boxId;
	

	public ScheduledCardsTestData(
		@JsonProperty("newScheduledCards") java.util.List<com.anfelisa.box.data.ScheduledCardTestData> newScheduledCards, 
		@JsonProperty("existingScheduledCardIds") java.util.List<String> existingScheduledCardIds, 
		@JsonProperty("cardIds") java.util.List<String> cardIds, 
		@JsonProperty("scheduledDate") String scheduledDate, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
		this.newScheduledCards = newScheduledCards;
		this.existingScheduledCardIds = existingScheduledCardIds;
		this.cardIds = cardIds;
		this.scheduledDate = scheduledDate;
		this.userId = userId;
		this.boxId = boxId;
	}

	public ScheduledCardsTestData(
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
	}

	public ScheduledCardsTestData() {
	}

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	public java.util.List<com.anfelisa.box.data.ScheduledCardTestData> getNewScheduledCards() {
		return this.newScheduledCards;
	}
	public void setNewScheduledCards(java.util.List<com.anfelisa.box.data.ScheduledCardTestData> newScheduledCards) {
		this.newScheduledCards = newScheduledCards;
	}
	
	public java.util.List<String> getExistingScheduledCardIds() {
		return this.existingScheduledCardIds;
	}
	public void setExistingScheduledCardIds(java.util.List<String> existingScheduledCardIds) {
		this.existingScheduledCardIds = existingScheduledCardIds;
	}
	
	public java.util.List<String> getCardIds() {
		return this.cardIds;
	}
	public void setCardIds(java.util.List<String> cardIds) {
		this.cardIds = cardIds;
	}
	
	public String getScheduledDate() {
		return this.scheduledDate;
	}
	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
}




/******* S.D.G. *******/



