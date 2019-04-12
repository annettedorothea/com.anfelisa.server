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
import com.anfelisa.box.models.IScheduledCardModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractScheduledCardData extends AbstractData implements IScheduledCardData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractScheduledCardData.class);
	
	@NotNull
	private String scheduledCardId;
	
	@NotNull
	private String cardId;
	
	@NotNull
	private String boxId;
	
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
	

	public AbstractScheduledCardData(
		@JsonProperty("scheduledCardId") String scheduledCardId,
		@JsonProperty("cardId") String cardId,
		@JsonProperty("boxId") String boxId,
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
		this.scheduledCardId = scheduledCardId;
		this.cardId = cardId;
		this.boxId = boxId;
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

	public AbstractScheduledCardData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
		public String getScheduledCardId() {
			return this.scheduledCardId;
		}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	public IScheduledCardData withScheduledCardId(String scheduledCardId) {
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
	public IScheduledCardData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
		public String getBoxId() {
			return this.boxId;
		}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IScheduledCardData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
		public org.joda.time.DateTime getCreatedDate() {
			return this.createdDate;
		}
	public void setCreatedDate(org.joda.time.DateTime createdDate) {
		this.createdDate = createdDate;
	}
	public IScheduledCardData withCreatedDate(org.joda.time.DateTime createdDate) {
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
	public IScheduledCardData withEf(Float ef) {
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
	public IScheduledCardData withInterval(Integer interval) {
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
	public IScheduledCardData withN(Integer n) {
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
	public IScheduledCardData withCount(Integer count) {
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
	public IScheduledCardData withScheduledDate(org.joda.time.DateTime scheduledDate) {
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
	public IScheduledCardData withLastQuality(Integer lastQuality) {
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
	public IScheduledCardData withQuality(Integer quality) {
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
	public IScheduledCardData withScoredDate(org.joda.time.DateTime scoredDate) {
		this.scoredDate = scoredDate;
		return this;
	}
	
	
	
}




/******* S.D.G. *******/



