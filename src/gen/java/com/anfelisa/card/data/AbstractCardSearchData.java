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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.card.models.ICardSearchModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;

@SuppressWarnings("unused")
public abstract class AbstractCardSearchData extends AbstractData implements ICardSearchData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCardSearchData.class);
	
	private String userId;
	
	@NotNull
	private String given;
	
	@NotNull
	private String wanted;
	
	private String categoryId;
	
	private java.util.List<com.anfelisa.card.models.ICardWithCategoryNameModel> cardList;
	
	private Boolean naturalInputOrder = false;
	

	public AbstractCardSearchData(
		@JsonProperty("userId") String userId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("cardList") java.util.List<com.anfelisa.card.models.ICardWithCategoryNameModel> cardList,
		@JsonProperty("naturalInputOrder") Boolean naturalInputOrder
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.given = given;
		this.wanted = wanted;
		this.categoryId = categoryId;
		this.cardList = cardList;
		this.naturalInputOrder = naturalInputOrder;
	}

	public AbstractCardSearchData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ICardSearchData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	public void setGiven(String given) {
		this.given = given;
	}
	public ICardSearchData withGiven(String given) {
		this.given = given;
		return this;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	public void setWanted(String wanted) {
		this.wanted = wanted;
	}
	public ICardSearchData withWanted(String wanted) {
		this.wanted = wanted;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public ICardSearchData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ICardWithCategoryNameModel> getCardList() {
		return this.cardList;
	}
	public void setCardList(java.util.List<com.anfelisa.card.models.ICardWithCategoryNameModel> cardList) {
		this.cardList = cardList;
	}
	public ICardSearchData withCardList(java.util.List<com.anfelisa.card.models.ICardWithCategoryNameModel> cardList) {
		this.cardList = cardList;
		return this;
	}
	
	@JsonProperty
	public Boolean getNaturalInputOrder() {
		return this.naturalInputOrder;
	}
	public void setNaturalInputOrder(Boolean naturalInputOrder) {
		this.naturalInputOrder = naturalInputOrder;
	}
	public ICardSearchData withNaturalInputOrder(Boolean naturalInputOrder) {
		this.naturalInputOrder = naturalInputOrder;
		return this;
	}
	
	
	
}




/******* S.D.G. *******/



