package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ScoreCardModel implements IScoreCardModel {

	@NotNull
	private String scheduledCardId;
	
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
	private Boolean removed = false;
	

	public ScoreCardModel(
		@JsonProperty("scheduledCardId") String scheduledCardId,
		@JsonProperty("createdDate") org.joda.time.DateTime createdDate,
		@JsonProperty("ef") Float ef,
		@JsonProperty("interval") Integer interval,
		@JsonProperty("n") Integer n,
		@JsonProperty("count") Integer count,
		@JsonProperty("scheduledDate") org.joda.time.DateTime scheduledDate,
		@JsonProperty("lastQuality") Integer lastQuality,
		@JsonProperty("quality") Integer quality,
		@JsonProperty("scoredDate") org.joda.time.DateTime scoredDate,
		@JsonProperty("removed") Boolean removed
	) {
		this.scheduledCardId = scheduledCardId;
		this.createdDate = createdDate;
		this.ef = ef;
		this.interval = interval;
		this.n = n;
		this.count = count;
		this.scheduledDate = scheduledDate;
		this.lastQuality = lastQuality;
		this.quality = quality;
		this.scoredDate = scoredDate;
		this.removed = removed;
	}

	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getCreatedDate() {
		return this.createdDate;
	}
	public void setCreatedDate(org.joda.time.DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonProperty
	public Float getEf() {
		return this.ef;
	}
	public void setEf(Float ef) {
		this.ef = ef;
	}
	
	@JsonProperty
	public Integer getInterval() {
		return this.interval;
	}
	public void setInterval(Integer interval) {
		this.interval = interval;
	}
	
	@JsonProperty
	public Integer getN() {
		return this.n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	
	@JsonProperty
	public Integer getCount() {
		return this.count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getScheduledDate() {
		return this.scheduledDate;
	}
	public void setScheduledDate(org.joda.time.DateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	
	@JsonProperty
	public Integer getLastQuality() {
		return this.lastQuality;
	}
	public void setLastQuality(Integer lastQuality) {
		this.lastQuality = lastQuality;
	}
	
	@JsonProperty
	public Integer getQuality() {
		return this.quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getScoredDate() {
		return this.scoredDate;
	}
	public void setScoredDate(org.joda.time.DateTime scoredDate) {
		this.scoredDate = scoredDate;
	}
	
	@JsonProperty
	public Boolean getRemoved() {
		return this.removed;
	}
	public void setRemoved(Boolean removed) {
		this.removed = removed;
	}
	

}

/*       S.D.G.       */
