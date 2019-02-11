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
import com.anfelisa.box.models.IScheduleNextCardModel;
import com.anfelisa.box.models.IScheduledCardModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractScheduleNextCardData extends AbstractData implements IScheduleNextCardData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractScheduleNextCardData.class);
	
	private String userId;
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String scheduledCardId;
	
	@NotNull
	private String cardId;
	
	@NotNull
	private org.joda.time.DateTime createdDate;
	
	@NotNull
	private Float ef;
	
	private Integer interval;
	
	@NotNull
	private Integer n;
	
	@NotNull
	private Integer count;
	
	@NotNull
	private org.joda.time.DateTime scheduledDate;
	
	private Integer lastQuality;
	
	private Integer quality;
	
	private org.joda.time.DateTime scoredDate;
	

	public AbstractScheduleNextCardData(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("scheduledCardId") String scheduledCardId,
		@JsonProperty("cardId") String cardId,
		@JsonProperty("createdDate") org.joda.time.DateTime createdDate,
		@JsonProperty("ef") Float ef,
		@JsonProperty("interval") Integer interval,
		@JsonProperty("n") Integer n,
		@JsonProperty("count") Integer count,
		@JsonProperty("scheduledDate") org.joda.time.DateTime scheduledDate,
		@JsonProperty("lastQuality") Integer lastQuality,
		@JsonProperty("quality") Integer quality,
		@JsonProperty("scoredDate") org.joda.time.DateTime scoredDate
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.boxId = boxId;
		this.scheduledCardId = scheduledCardId;
		this.cardId = cardId;
		this.createdDate = createdDate;
		this.ef = ef;
		this.interval = interval;
		this.n = n;
		this.count = count;
		this.scheduledDate = scheduledDate;
		this.lastQuality = lastQuality;
		this.quality = quality;
		this.scoredDate = scoredDate;
	}

	public AbstractScheduleNextCardData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IScheduleNextCardData withUserId(String userId) {
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
	public IScheduleNextCardData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	public IScheduleNextCardData withScheduledCardId(String scheduledCardId) {
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
	public IScheduleNextCardData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getCreatedDate() {
		return this.createdDate;
	}
	public void setCreatedDate(org.joda.time.DateTime createdDate) {
		this.createdDate = createdDate;
	}
	public IScheduleNextCardData withCreatedDate(org.joda.time.DateTime createdDate) {
		this.createdDate = createdDate;
		return this;
	}
	
	@JsonProperty
	public Float getEf() {
		return this.ef;
	}
	public void setEf(Float ef) {
		this.ef = ef;
	}
	public IScheduleNextCardData withEf(Float ef) {
		this.ef = ef;
		return this;
	}
	
	@JsonProperty
	public Integer getInterval() {
		return this.interval;
	}
	public void setInterval(Integer interval) {
		this.interval = interval;
	}
	public IScheduleNextCardData withInterval(Integer interval) {
		this.interval = interval;
		return this;
	}
	
	@JsonProperty
	public Integer getN() {
		return this.n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	public IScheduleNextCardData withN(Integer n) {
		this.n = n;
		return this;
	}
	
	@JsonProperty
	public Integer getCount() {
		return this.count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public IScheduleNextCardData withCount(Integer count) {
		this.count = count;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getScheduledDate() {
		return this.scheduledDate;
	}
	public void setScheduledDate(org.joda.time.DateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	public IScheduleNextCardData withScheduledDate(org.joda.time.DateTime scheduledDate) {
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
	public IScheduleNextCardData withLastQuality(Integer lastQuality) {
		this.lastQuality = lastQuality;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality() {
		return this.quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	public IScheduleNextCardData withQuality(Integer quality) {
		this.quality = quality;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getScoredDate() {
		return this.scoredDate;
	}
	public void setScoredDate(org.joda.time.DateTime scoredDate) {
		this.scoredDate = scoredDate;
	}
	public IScheduleNextCardData withScoredDate(org.joda.time.DateTime scoredDate) {
		this.scoredDate = scoredDate;
		return this;
	}
	
	
	public void mapFrom(com.anfelisa.box.models.IScheduledCardModel model) {
		this.scheduledCardId = model.getScheduledCardId();
		this.cardId = model.getCardId();
		this.boxId = model.getBoxId();
		this.createdDate = model.getCreatedDate();
		this.ef = model.getEf();
		this.interval = model.getInterval();
		this.n = model.getN();
		this.count = model.getCount();
		this.scheduledDate = model.getScheduledDate();
		this.lastQuality = model.getLastQuality();
		this.quality = model.getQuality();
		this.scoredDate = model.getScoredDate();
	}
	
	public List<String> equalsPrimitiveTypes(com.anfelisa.box.models.IScheduleNextCardModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		if (!(this.getBoxId() == null && other.getBoxId() == null) && !this.getBoxId().equals(other.getBoxId())) {
			differingAttributes.add("boxId: " + this.getBoxId() + " " + other.getBoxId());
		}
		return differingAttributes;
	}
	
	public List<String> equalsPrimitiveTypes(com.anfelisa.box.models.IScheduledCardModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getScheduledCardId() == null && other.getScheduledCardId() == null) && !this.getScheduledCardId().equals(other.getScheduledCardId())) {
			differingAttributes.add("scheduledCardId: " + this.getScheduledCardId() + " " + other.getScheduledCardId());
		}
		if (!(this.getCardId() == null && other.getCardId() == null) && !this.getCardId().equals(other.getCardId())) {
			differingAttributes.add("cardId: " + this.getCardId() + " " + other.getCardId());
		}
		if (!(this.getBoxId() == null && other.getBoxId() == null) && !this.getBoxId().equals(other.getBoxId())) {
			differingAttributes.add("boxId: " + this.getBoxId() + " " + other.getBoxId());
		}
		if (!(this.getCreatedDate() == null && other.getCreatedDate() == null) && !this.getCreatedDate().equals(other.getCreatedDate())) {
			differingAttributes.add("createdDate: " + this.getCreatedDate() + " " + other.getCreatedDate());
		}
		if (!(this.getEf() == null && other.getEf() == null) && !this.getEf().equals(other.getEf())) {
			differingAttributes.add("ef: " + this.getEf() + " " + other.getEf());
		}
		if (!(this.getInterval() == null && other.getInterval() == null) && !this.getInterval().equals(other.getInterval())) {
			differingAttributes.add("interval: " + this.getInterval() + " " + other.getInterval());
		}
		if (!(this.getN() == null && other.getN() == null) && !this.getN().equals(other.getN())) {
			differingAttributes.add("n: " + this.getN() + " " + other.getN());
		}
		if (!(this.getCount() == null && other.getCount() == null) && !this.getCount().equals(other.getCount())) {
			differingAttributes.add("count: " + this.getCount() + " " + other.getCount());
		}
		if (!(this.getScheduledDate() == null && other.getScheduledDate() == null) && !this.getScheduledDate().equals(other.getScheduledDate())) {
			differingAttributes.add("scheduledDate: " + this.getScheduledDate() + " " + other.getScheduledDate());
		}
		if (!(this.getLastQuality() == null && other.getLastQuality() == null) && !this.getLastQuality().equals(other.getLastQuality())) {
			differingAttributes.add("lastQuality: " + this.getLastQuality() + " " + other.getLastQuality());
		}
		if (!(this.getQuality() == null && other.getQuality() == null) && !this.getQuality().equals(other.getQuality())) {
			differingAttributes.add("quality: " + this.getQuality() + " " + other.getQuality());
		}
		if (!(this.getScoredDate() == null && other.getScoredDate() == null) && !this.getScoredDate().equals(other.getScoredDate())) {
			differingAttributes.add("scoredDate: " + this.getScoredDate() + " " + other.getScoredDate());
		}
		return differingAttributes;
	}
	
	
}




/******* S.D.G. *******/



