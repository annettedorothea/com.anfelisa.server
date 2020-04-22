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




package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.joda.time.DateTime;
import java.util.List;

@SuppressWarnings("unused")
public class ChangeCardOrderListTestData {
	
	private String uuid;

	private java.util.List<String> cardIdList;
	
	private String cardId;
	
	private String userId;
	
	private java.util.List<com.anfelisa.card.data.CardTestData> updatedIndices;
	

	public ChangeCardOrderListTestData(
		@JsonProperty("cardIdList") java.util.List<String> cardIdList, 
		@JsonProperty("cardId") String cardId, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("updatedIndices") java.util.List<com.anfelisa.card.data.CardTestData> updatedIndices, 
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
		this.cardIdList = cardIdList;
		this.cardId = cardId;
		this.userId = userId;
		this.updatedIndices = updatedIndices;
	}

	public ChangeCardOrderListTestData(
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
	}

	public ChangeCardOrderListTestData() {
	}

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	public java.util.List<String> getCardIdList() {
		return this.cardIdList;
	}
	public void setCardIdList(java.util.List<String> cardIdList) {
		this.cardIdList = cardIdList;
	}
	
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public java.util.List<com.anfelisa.card.data.CardTestData> getUpdatedIndices() {
		return this.updatedIndices;
	}
	public void setUpdatedIndices(java.util.List<com.anfelisa.card.data.CardTestData> updatedIndices) {
		this.updatedIndices = updatedIndices;
	}
	
}




/******* S.D.G. *******/



