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
public class CardSearchTestData {
	
	private String uuid;

	private String userId;
	
	private String given;
	
	private String wanted;
	
	private String categoryId;
	
	private java.util.List<com.anfelisa.card.data.CardWithCategoryNameTestData> cardList;
	
	private Boolean naturalInputOrder = false;
	

	public CardSearchTestData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("given") String given, 
		@JsonProperty("wanted") String wanted, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("cardList") java.util.List<com.anfelisa.card.data.CardWithCategoryNameTestData> cardList, 
		@JsonProperty("naturalInputOrder") Boolean naturalInputOrder, 
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
		this.userId = userId;
		this.given = given;
		this.wanted = wanted;
		this.categoryId = categoryId;
		this.cardList = cardList;
		this.naturalInputOrder = naturalInputOrder;
	}

	public CardSearchTestData(
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
	}

	public CardSearchTestData() {
	}

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getGiven() {
		return this.given;
	}
	public void setGiven(String given) {
		this.given = given;
	}
	
	public String getWanted() {
		return this.wanted;
	}
	public void setWanted(String wanted) {
		this.wanted = wanted;
	}
	
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	public java.util.List<com.anfelisa.card.data.CardWithCategoryNameTestData> getCardList() {
		return this.cardList;
	}
	public void setCardList(java.util.List<com.anfelisa.card.data.CardWithCategoryNameTestData> cardList) {
		this.cardList = cardList;
	}
	
	public Boolean getNaturalInputOrder() {
		return this.naturalInputOrder;
	}
	public void setNaturalInputOrder(Boolean naturalInputOrder) {
		this.naturalInputOrder = naturalInputOrder;
	}
	
}




/******* S.D.G. *******/



