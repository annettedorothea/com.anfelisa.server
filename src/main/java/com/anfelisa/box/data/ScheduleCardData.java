package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleCardData extends AbstractData implements IScheduleCardData {
	
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
	
	@NotNull
	private String userId;
	

	public ScheduleCardData(
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
		@JsonProperty("scoredDate") org.joda.time.DateTime scoredDate,
		@JsonProperty("userId") String userId
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
		this.userId = userId;
	}

	public ScheduleCardData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	public ScheduleCardData withScheduledCardId(String scheduledCardId) {
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
	public ScheduleCardData withCardId(String cardId) {
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
	public ScheduleCardData withBoxId(String boxId) {
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
	public ScheduleCardData withCreatedDate(org.joda.time.DateTime createdDate) {
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
	public ScheduleCardData withEf(Float ef) {
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
	public ScheduleCardData withInterval(Integer interval) {
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
	public ScheduleCardData withN(Integer n) {
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
	public ScheduleCardData withCount(Integer count) {
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
	public ScheduleCardData withScheduledDate(org.joda.time.DateTime scheduledDate) {
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
	public ScheduleCardData withLastQuality(Integer lastQuality) {
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
	public ScheduleCardData withQuality(Integer quality) {
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
	public ScheduleCardData withScoredDate(org.joda.time.DateTime scoredDate) {
		this.scoredDate = scoredDate;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ScheduleCardData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new ScheduleCardPresentationalData(
			this.scheduledCardId,
			this.cardId,
			this.boxId,
			this.createdDate,
			this.ef,
			this.interval,
			this.n,
			this.count,
			this.scheduledDate,
			this.lastQuality,
			this.quality,
			this.scoredDate,
			this.userId
		);
	}

}

/*       S.D.G.       */
