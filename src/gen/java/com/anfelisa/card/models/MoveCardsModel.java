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
 * generated with de.acegen 0.9.7
 *
 */




package com.anfelisa.card.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class MoveCardsModel implements IMoveCardsModel {

	private java.util.List<String> cardIdList;

	private String categoryId;

	private String userId;

	private java.util.List<com.anfelisa.card.models.ICardModel> movedCards;

	private java.util.List<com.anfelisa.card.models.ICardModel> updatedIndices;


	public MoveCardsModel() {
	}

	public MoveCardsModel(
		@JsonProperty("cardIdList") java.util.List<String> cardIdList,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("userId") String userId,
		@JsonProperty("movedCards") java.util.List<com.anfelisa.card.models.ICardModel> movedCards,
		@JsonProperty("updatedIndices") java.util.List<com.anfelisa.card.models.ICardModel> updatedIndices
	) {
		this.cardIdList = cardIdList;
		this.categoryId = categoryId;
		this.userId = userId;
		this.movedCards = movedCards;
		this.updatedIndices = updatedIndices;
	}

	@JsonProperty
	public java.util.List<String> getCardIdList() {
		return this.cardIdList;
	}
	public void setCardIdList(java.util.List<String> cardIdList) {
		this.cardIdList = cardIdList;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ICardModel> getMovedCards() {
		return this.movedCards;
	}
	public void setMovedCards(java.util.List<com.anfelisa.card.models.ICardModel> movedCards) {
		this.movedCards = movedCards;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ICardModel> getUpdatedIndices() {
		return this.updatedIndices;
	}
	public void setUpdatedIndices(java.util.List<com.anfelisa.card.models.ICardModel> updatedIndices) {
		this.updatedIndices = updatedIndices;
	}
	
}



/******* S.D.G. *******/



