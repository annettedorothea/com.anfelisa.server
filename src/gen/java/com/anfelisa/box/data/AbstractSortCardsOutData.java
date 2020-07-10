/* 
 * Copyright (c) 2020, Annette Pohl, Koblenz, Germany
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
 *
 * generated with de.acegen 0.9.6
 *
 */




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.ISortCardsOutModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractSortCardsOutData extends AbstractData implements ISortCardsOutData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractSortCardsOutData.class);
	
	private java.util.List<String> sortedOutScheduledCardIds;
	
	private java.util.List<String> sortedOutReinforceCardIds;
	
	private java.util.List<String> cardIds;
	
	private String userId;
	
	private String boxId;
	

	public AbstractSortCardsOutData(
		@JsonProperty("sortedOutScheduledCardIds") java.util.List<String> sortedOutScheduledCardIds,
		@JsonProperty("sortedOutReinforceCardIds") java.util.List<String> sortedOutReinforceCardIds,
		@JsonProperty("cardIds") java.util.List<String> cardIds,
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.sortedOutScheduledCardIds = sortedOutScheduledCardIds;
		this.sortedOutReinforceCardIds = sortedOutReinforceCardIds;
		this.cardIds = cardIds;
		this.userId = userId;
		this.boxId = boxId;
	}

	public AbstractSortCardsOutData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public java.util.List<String> getSortedOutScheduledCardIds() {
		return this.sortedOutScheduledCardIds;
	}
	public void setSortedOutScheduledCardIds(java.util.List<String> sortedOutScheduledCardIds) {
		this.sortedOutScheduledCardIds = sortedOutScheduledCardIds;
	}
	public ISortCardsOutData withSortedOutScheduledCardIds(java.util.List<String> sortedOutScheduledCardIds) {
		this.sortedOutScheduledCardIds = sortedOutScheduledCardIds;
		return this;
	}
	
	@JsonProperty
	public java.util.List<String> getSortedOutReinforceCardIds() {
		return this.sortedOutReinforceCardIds;
	}
	public void setSortedOutReinforceCardIds(java.util.List<String> sortedOutReinforceCardIds) {
		this.sortedOutReinforceCardIds = sortedOutReinforceCardIds;
	}
	public ISortCardsOutData withSortedOutReinforceCardIds(java.util.List<String> sortedOutReinforceCardIds) {
		this.sortedOutReinforceCardIds = sortedOutReinforceCardIds;
		return this;
	}
	
	@JsonProperty
	public java.util.List<String> getCardIds() {
		return this.cardIds;
	}
	public void setCardIds(java.util.List<String> cardIds) {
		this.cardIds = cardIds;
	}
	public ISortCardsOutData withCardIds(java.util.List<String> cardIds) {
		this.cardIds = cardIds;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ISortCardsOutData withUserId(String userId) {
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
	public ISortCardsOutData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	
	
}



/******* S.D.G. *******/



