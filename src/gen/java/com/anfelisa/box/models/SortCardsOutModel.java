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




package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class SortCardsOutModel implements ISortCardsOutModel {

	private java.util.List<String> sortedOutScheduledCardIds;
	
	private java.util.List<String> sortedOutReinforceCardIds;
	
	private java.util.List<String> cardIds;
	
	private String userId;
	
	private String boxId;
	

	public SortCardsOutModel() {
	}

	public SortCardsOutModel(
		@JsonProperty("sortedOutScheduledCardIds") java.util.List<String> sortedOutScheduledCardIds,
		@JsonProperty("sortedOutReinforceCardIds") java.util.List<String> sortedOutReinforceCardIds,
		@JsonProperty("cardIds") java.util.List<String> cardIds,
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId
	) {
		this.sortedOutScheduledCardIds = sortedOutScheduledCardIds;
		this.sortedOutReinforceCardIds = sortedOutReinforceCardIds;
		this.cardIds = cardIds;
		this.userId = userId;
		this.boxId = boxId;
	}

	@JsonProperty
	public java.util.List<String> getSortedOutScheduledCardIds() {
		return this.sortedOutScheduledCardIds;
	}
	public void setSortedOutScheduledCardIds(java.util.List<String> sortedOutScheduledCardIds) {
		this.sortedOutScheduledCardIds = sortedOutScheduledCardIds;
	}
	
	@JsonProperty
	public java.util.List<String> getSortedOutReinforceCardIds() {
		return this.sortedOutReinforceCardIds;
	}
	public void setSortedOutReinforceCardIds(java.util.List<String> sortedOutReinforceCardIds) {
		this.sortedOutReinforceCardIds = sortedOutReinforceCardIds;
	}
	
	@JsonProperty
	public java.util.List<String> getCardIds() {
		return this.cardIds;
	}
	public void setCardIds(java.util.List<String> cardIds) {
		this.cardIds = cardIds;
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
	
}
	


/******* S.D.G. *******/



