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

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.card.models.IMoveCardsModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractMoveCardsData extends AbstractData implements IMoveCardsData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractMoveCardsData.class);
	
	private java.util.List<String> cardIdList;
	
	private String categoryId;
	
	private String userId;
	
	private java.util.List<com.anfelisa.card.models.ICardModel> movedCards;
	
	private java.util.List<com.anfelisa.card.models.ICardModel> updatedIndices;
	

	public AbstractMoveCardsData(
		@JsonProperty("cardIdList") java.util.List<String> cardIdList,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("userId") String userId,
		@JsonProperty("movedCards") java.util.List<com.anfelisa.card.models.ICardModel> movedCards,
		@JsonProperty("updatedIndices") java.util.List<com.anfelisa.card.models.ICardModel> updatedIndices
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.cardIdList = cardIdList;
		this.categoryId = categoryId;
		this.userId = userId;
		this.movedCards = movedCards;
		this.updatedIndices = updatedIndices;
	}

	public AbstractMoveCardsData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
		public java.util.List<String> getCardIdList() {
			return this.cardIdList;
		}
	public void setCardIdList(java.util.List<String> cardIdList) {
		this.cardIdList = cardIdList;
	}
	public IMoveCardsData withCardIdList(java.util.List<String> cardIdList) {
		this.cardIdList = cardIdList;
		return this;
	}
	
	@JsonProperty
		public String getCategoryId() {
			return this.categoryId;
		}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public IMoveCardsData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
		public String getUserId() {
			return this.userId;
		}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IMoveCardsData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
		public java.util.List<com.anfelisa.card.models.ICardModel> getMovedCards() {
			return this.movedCards;
		}
	public void setMovedCards(java.util.List<com.anfelisa.card.models.ICardModel> movedCards) {
		this.movedCards = movedCards;
	}
	public IMoveCardsData withMovedCards(java.util.List<com.anfelisa.card.models.ICardModel> movedCards) {
		this.movedCards = movedCards;
		return this;
	}
	
	@JsonProperty
		public java.util.List<com.anfelisa.card.models.ICardModel> getUpdatedIndices() {
			return this.updatedIndices;
		}
	public void setUpdatedIndices(java.util.List<com.anfelisa.card.models.ICardModel> updatedIndices) {
		this.updatedIndices = updatedIndices;
	}
	public IMoveCardsData withUpdatedIndices(java.util.List<com.anfelisa.card.models.ICardModel> updatedIndices) {
		this.updatedIndices = updatedIndices;
		return this;
	}
	
	
	
}




/******* S.D.G. *******/



