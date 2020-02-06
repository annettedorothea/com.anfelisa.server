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
import com.anfelisa.box.models.INextCardModel;
import com.anfelisa.box.models.INextCardViewModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractNextCardData extends AbstractData implements INextCardData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractNextCardData.class);
	
	private String userId;
	
	@NotNull
	private org.joda.time.DateTime today;
	
	@NotNull
	private String scheduledCardId;
	
	@NotNull
	private String cardId;
	
	@NotNull
	private org.joda.time.DateTime scheduledDate;
	
	private Integer lastQuality;
	
	private String given;
	
	private String wanted;
	
	private String image;
	
	private String categoryId;
	
	private String rootCategoryId;
	
	@NotNull
	private Integer count;
	
	private org.joda.time.DateTime scoredDate;
	
	@NotNull
	private String boxId;
	
	private Integer openTodaysCards;
	
	private Integer allTodaysCards;
	

	public AbstractNextCardData(
		@JsonProperty("userId") String userId,
		@JsonProperty("today") org.joda.time.DateTime today,
		@JsonProperty("scheduledCardId") String scheduledCardId,
		@JsonProperty("cardId") String cardId,
		@JsonProperty("scheduledDate") org.joda.time.DateTime scheduledDate,
		@JsonProperty("lastQuality") Integer lastQuality,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("image") String image,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("count") Integer count,
		@JsonProperty("scoredDate") org.joda.time.DateTime scoredDate,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("openTodaysCards") Integer openTodaysCards,
		@JsonProperty("allTodaysCards") Integer allTodaysCards
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.today = today;
		this.scheduledCardId = scheduledCardId;
		this.cardId = cardId;
		this.scheduledDate = scheduledDate;
		this.lastQuality = lastQuality;
		this.given = given;
		this.wanted = wanted;
		this.image = image;
		this.categoryId = categoryId;
		this.rootCategoryId = rootCategoryId;
		this.count = count;
		this.scoredDate = scoredDate;
		this.boxId = boxId;
		this.openTodaysCards = openTodaysCards;
		this.allTodaysCards = allTodaysCards;
	}

	public AbstractNextCardData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
		public String getUserId() {
			return this.userId;
		}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public INextCardData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
		public org.joda.time.DateTime getToday() {
			return this.today;
		}
	public void setToday(org.joda.time.DateTime today) {
		this.today = today;
	}
	public INextCardData withToday(org.joda.time.DateTime today) {
		this.today = today;
		return this;
	}
	
	@JsonProperty
		public String getScheduledCardId() {
			return this.scheduledCardId;
		}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	public INextCardData withScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
		return this;
	}
	
	@JsonProperty
		public String getCardId() {
			return this.cardId;
		}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public INextCardData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
		public org.joda.time.DateTime getScheduledDate() {
			return this.scheduledDate;
		}
	public void setScheduledDate(org.joda.time.DateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	public INextCardData withScheduledDate(org.joda.time.DateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
		return this;
	}
	
	@JsonProperty
		public Integer getLastQuality() {
			return this.lastQuality;
		}
	public void setLastQuality(Integer lastQuality) {
		this.lastQuality = lastQuality;
	}
	public INextCardData withLastQuality(Integer lastQuality) {
		this.lastQuality = lastQuality;
		return this;
	}
	
	@JsonProperty
		public String getGiven() {
			return this.given;
		}
	public void setGiven(String given) {
		this.given = given;
	}
	public INextCardData withGiven(String given) {
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
	public INextCardData withWanted(String wanted) {
		this.wanted = wanted;
		return this;
	}
	
	@JsonProperty
		public String getImage() {
			return this.image;
		}
	public void setImage(String image) {
		this.image = image;
	}
	public INextCardData withImage(String image) {
		this.image = image;
		return this;
	}
	
	@JsonProperty
		public String getCategoryId() {
			return this.categoryId;
		}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public INextCardData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
		public String getRootCategoryId() {
			return this.rootCategoryId;
		}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	public INextCardData withRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
		return this;
	}
	
	@JsonProperty
		public Integer getCount() {
			return this.count;
		}
	public void setCount(Integer count) {
		this.count = count;
	}
	public INextCardData withCount(Integer count) {
		this.count = count;
		return this;
	}
	
	@JsonProperty
		public org.joda.time.DateTime getScoredDate() {
			return this.scoredDate;
		}
	public void setScoredDate(org.joda.time.DateTime scoredDate) {
		this.scoredDate = scoredDate;
	}
	public INextCardData withScoredDate(org.joda.time.DateTime scoredDate) {
		this.scoredDate = scoredDate;
		return this;
	}
	
	@JsonProperty
		public String getBoxId() {
			return this.boxId;
		}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public INextCardData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
		public Integer getOpenTodaysCards() {
			return this.openTodaysCards;
		}
	public void setOpenTodaysCards(Integer openTodaysCards) {
		this.openTodaysCards = openTodaysCards;
	}
	public INextCardData withOpenTodaysCards(Integer openTodaysCards) {
		this.openTodaysCards = openTodaysCards;
		return this;
	}
	
	@JsonProperty
		public Integer getAllTodaysCards() {
			return this.allTodaysCards;
		}
	public void setAllTodaysCards(Integer allTodaysCards) {
		this.allTodaysCards = allTodaysCards;
	}
	public INextCardData withAllTodaysCards(Integer allTodaysCards) {
		this.allTodaysCards = allTodaysCards;
		return this;
	}
	
	
	public void mapFrom(com.anfelisa.box.models.INextCardViewModel model) {
		this.scheduledCardId = model.getScheduledCardId();
		this.cardId = model.getCardId();
		this.scheduledDate = model.getScheduledDate();
		this.lastQuality = model.getLastQuality();
		this.given = model.getGiven();
		this.wanted = model.getWanted();
		this.image = model.getImage();
		this.categoryId = model.getCategoryId();
		this.rootCategoryId = model.getRootCategoryId();
		this.count = model.getCount();
		this.scoredDate = model.getScoredDate();
		this.boxId = model.getBoxId();
		this.openTodaysCards = model.getOpenTodaysCards();
		this.allTodaysCards = model.getAllTodaysCards();
	}
	
}




/******* S.D.G. *******/



