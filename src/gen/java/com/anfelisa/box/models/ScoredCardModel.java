package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ScoredCardModel implements IScoredCardModel {

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
	

	public ScoredCardModel(
		@JsonProperty("scoredCardId") String scoredCardId,
		@JsonProperty("cardId") String cardId,
		@JsonProperty("scheduledDateOfScored") org.joda.time.DateTime scheduledDateOfScored,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("quality") Integer quality,
		@JsonProperty("timestamp") org.joda.time.DateTime timestamp,
		@JsonProperty("points") Integer points,
		@JsonProperty("scheduledCardId") String scheduledCardId
	) {
		this.scoredCardId = scoredCardId;
		this.cardId = cardId;
		this.scheduledDateOfScored = scheduledDateOfScored;
		this.boxId = boxId;
		this.quality = quality;
		this.timestamp = timestamp;
		this.points = points;
		this.scheduledCardId = scheduledCardId;
	}

	@JsonProperty
	public String getScoredCardId() {
		return this.scoredCardId;
	}
	public void setScoredCardId(String scoredCardId) {
		this.scoredCardId = scoredCardId;
	}
	
	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getScheduledDateOfScored() {
		return this.scheduledDateOfScored;
	}
	public void setScheduledDateOfScored(org.joda.time.DateTime scheduledDateOfScored) {
		this.scheduledDateOfScored = scheduledDateOfScored;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
	public Integer getQuality() {
		return this.quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getTimestamp() {
		return this.timestamp;
	}
	public void setTimestamp(org.joda.time.DateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	@JsonProperty
	public Integer getPoints() {
		return this.points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	

}

/*       S.D.G.       */
