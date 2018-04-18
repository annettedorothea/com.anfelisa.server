package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoredCardData extends AbstractData implements IScoredCardData {
	
	@NotNull
	private String scoredCardId;
	
	@NotNull
	private String cardId;
	
	private org.joda.time.DateTime scheduledDateOfScored;
	
	@NotNull
	private String boxId;
	
	private Integer quality;
	
	@NotNull
	private org.joda.time.DateTime timestamp;
	
	private Integer points;
	
	@NotNull
	private String scheduledCardId;
	

	public ScoredCardData(
		@JsonProperty("scoredCardId") String scoredCardId,
		@JsonProperty("cardId") String cardId,
		@JsonProperty("scheduledDateOfScored") org.joda.time.DateTime scheduledDateOfScored,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("quality") Integer quality,
		@JsonProperty("timestamp") org.joda.time.DateTime timestamp,
		@JsonProperty("points") Integer points,
		@JsonProperty("scheduledCardId") String scheduledCardId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.scoredCardId = scoredCardId;
		this.cardId = cardId;
		this.scheduledDateOfScored = scheduledDateOfScored;
		this.boxId = boxId;
		this.quality = quality;
		this.timestamp = timestamp;
		this.points = points;
		this.scheduledCardId = scheduledCardId;
	}

	public ScoredCardData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getScoredCardId() {
		return this.scoredCardId;
	}
	public void setScoredCardId(String scoredCardId) {
		this.scoredCardId = scoredCardId;
	}
	public ScoredCardData withScoredCardId(String scoredCardId) {
		this.scoredCardId = scoredCardId;
		return this;
	}
	
	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public ScoredCardData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getScheduledDateOfScored() {
		return this.scheduledDateOfScored;
	}
	public void setScheduledDateOfScored(org.joda.time.DateTime scheduledDateOfScored) {
		this.scheduledDateOfScored = scheduledDateOfScored;
	}
	public ScoredCardData withScheduledDateOfScored(org.joda.time.DateTime scheduledDateOfScored) {
		this.scheduledDateOfScored = scheduledDateOfScored;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public ScoredCardData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality() {
		return this.quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	public ScoredCardData withQuality(Integer quality) {
		this.quality = quality;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getTimestamp() {
		return this.timestamp;
	}
	public void setTimestamp(org.joda.time.DateTime timestamp) {
		this.timestamp = timestamp;
	}
	public ScoredCardData withTimestamp(org.joda.time.DateTime timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	
	@JsonProperty
	public Integer getPoints() {
		return this.points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public ScoredCardData withPoints(Integer points) {
		this.points = points;
		return this;
	}
	
	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	public ScoredCardData withScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new ScoredCardPresentationalData(
			this.scoredCardId,
			this.cardId,
			this.scheduledDateOfScored,
			this.boxId,
			this.quality,
			this.timestamp,
			this.points,
			this.scheduledCardId
		);
	}

}

/*       S.D.G.       */
