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
		@JsonProperty("boxId") String boxId
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
	}
	
	public List<String> equalsPrimitiveTypes(com.anfelisa.box.models.INextCardModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		if (!(this.getToday() == null && other.getToday() == null) && !this.getToday().equals(other.getToday())) {
			differingAttributes.add("today: " + this.getToday() + " " + other.getToday());
		}
		return differingAttributes;
	}
	
	public List<String> equalsPrimitiveTypes(com.anfelisa.box.models.INextCardViewModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getScheduledCardId() == null && other.getScheduledCardId() == null) && !this.getScheduledCardId().equals(other.getScheduledCardId())) {
			differingAttributes.add("scheduledCardId: " + this.getScheduledCardId() + " " + other.getScheduledCardId());
		}
		if (!(this.getCardId() == null && other.getCardId() == null) && !this.getCardId().equals(other.getCardId())) {
			differingAttributes.add("cardId: " + this.getCardId() + " " + other.getCardId());
		}
		if (!(this.getScheduledDate() == null && other.getScheduledDate() == null) && !this.getScheduledDate().equals(other.getScheduledDate())) {
			differingAttributes.add("scheduledDate: " + this.getScheduledDate() + " " + other.getScheduledDate());
		}
		if (!(this.getLastQuality() == null && other.getLastQuality() == null) && !this.getLastQuality().equals(other.getLastQuality())) {
			differingAttributes.add("lastQuality: " + this.getLastQuality() + " " + other.getLastQuality());
		}
		if (!(this.getGiven() == null && other.getGiven() == null) && !this.getGiven().equals(other.getGiven())) {
			differingAttributes.add("given: " + this.getGiven() + " " + other.getGiven());
		}
		if (!(this.getWanted() == null && other.getWanted() == null) && !this.getWanted().equals(other.getWanted())) {
			differingAttributes.add("wanted: " + this.getWanted() + " " + other.getWanted());
		}
		if (!(this.getImage() == null && other.getImage() == null) && !this.getImage().equals(other.getImage())) {
			differingAttributes.add("image: " + this.getImage() + " " + other.getImage());
		}
		if (!(this.getCategoryId() == null && other.getCategoryId() == null) && !this.getCategoryId().equals(other.getCategoryId())) {
			differingAttributes.add("categoryId: " + this.getCategoryId() + " " + other.getCategoryId());
		}
		if (!(this.getRootCategoryId() == null && other.getRootCategoryId() == null) && !this.getRootCategoryId().equals(other.getRootCategoryId())) {
			differingAttributes.add("rootCategoryId: " + this.getRootCategoryId() + " " + other.getRootCategoryId());
		}
		if (!(this.getCount() == null && other.getCount() == null) && !this.getCount().equals(other.getCount())) {
			differingAttributes.add("count: " + this.getCount() + " " + other.getCount());
		}
		if (!(this.getScoredDate() == null && other.getScoredDate() == null) && !this.getScoredDate().equals(other.getScoredDate())) {
			differingAttributes.add("scoredDate: " + this.getScoredDate() + " " + other.getScoredDate());
		}
		if (!(this.getBoxId() == null && other.getBoxId() == null) && !this.getBoxId().equals(other.getBoxId())) {
			differingAttributes.add("boxId: " + this.getBoxId() + " " + other.getBoxId());
		}
		return differingAttributes;
	}
	
	
}




/******* S.D.G. *******/



