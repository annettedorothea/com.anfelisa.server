package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduledCardData extends AbstractData implements IScheduledCardData {
	
	@NotNull
	private String scheduledCardId;
	
	@NotNull
	private String cardId;
	
	@NotNull
	private Float ef;
	
	private Integer interval;
	
	@NotNull
	private Integer n;
	
	@NotNull
	private Integer count;
	
	@NotNull
	private org.joda.time.DateTime scheduledDate;
	
	@NotNull
	private String boxId;
	
	private Integer lastQuality;
	
	@NotNull
	private org.joda.time.DateTime timestamp;
	
	@NotNull
	private Boolean removed = false;
	

	public ScheduledCardData(
		@JsonProperty("scheduledCardId") String scheduledCardId,
		@JsonProperty("cardId") String cardId,
		@JsonProperty("ef") Float ef,
		@JsonProperty("interval") Integer interval,
		@JsonProperty("n") Integer n,
		@JsonProperty("count") Integer count,
		@JsonProperty("scheduledDate") org.joda.time.DateTime scheduledDate,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("lastQuality") Integer lastQuality,
		@JsonProperty("timestamp") org.joda.time.DateTime timestamp,
		@JsonProperty("removed") Boolean removed
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.scheduledCardId = scheduledCardId;
		this.cardId = cardId;
		this.ef = ef;
		this.interval = interval;
		this.n = n;
		this.count = count;
		this.scheduledDate = scheduledDate;
		this.boxId = boxId;
		this.lastQuality = lastQuality;
		this.timestamp = timestamp;
		this.removed = removed;
	}

	public ScheduledCardData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	public ScheduledCardData withScheduledCardId(String scheduledCardId) {
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
	public ScheduledCardData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public Float getEf() {
		return this.ef;
	}
	public void setEf(Float ef) {
		this.ef = ef;
	}
	public ScheduledCardData withEf(Float ef) {
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
	public ScheduledCardData withInterval(Integer interval) {
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
	public ScheduledCardData withN(Integer n) {
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
	public ScheduledCardData withCount(Integer count) {
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
	public ScheduledCardData withScheduledDate(org.joda.time.DateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public ScheduledCardData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public Integer getLastQuality() {
		return this.lastQuality;
	}
	public void setLastQuality(Integer lastQuality) {
		this.lastQuality = lastQuality;
	}
	public ScheduledCardData withLastQuality(Integer lastQuality) {
		this.lastQuality = lastQuality;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getTimestamp() {
		return this.timestamp;
	}
	public void setTimestamp(org.joda.time.DateTime timestamp) {
		this.timestamp = timestamp;
	}
	public ScheduledCardData withTimestamp(org.joda.time.DateTime timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	
	@JsonProperty
	public Boolean getRemoved() {
		return this.removed;
	}
	public void setRemoved(Boolean removed) {
		this.removed = removed;
	}
	public ScheduledCardData withRemoved(Boolean removed) {
		this.removed = removed;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new ScheduledCardPresentationalData(
			this.scheduledCardId,
			this.cardId,
			this.ef,
			this.interval,
			this.n,
			this.count,
			this.scheduledDate,
			this.boxId,
			this.lastQuality,
			this.timestamp,
			this.removed
		);
	}

}

/*       S.D.G.       */
