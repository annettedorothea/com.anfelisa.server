package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScoredCardModel;

@SuppressWarnings("all")
public class ScoredCardData implements IScoredCardData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
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
	

	private org.joda.time.DateTime systemTime;
	
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
		this.scoredCardId = scoredCardId;
		this.cardId = cardId;
		this.scheduledDateOfScored = scheduledDateOfScored;
		this.boxId = boxId;
		this.quality = quality;
		this.timestamp = timestamp;
		this.points = points;
		this.scheduledCardId = scheduledCardId;
		this.uuid = uuid;
		
	}

	public ScoredCardData( String uuid ) {
		this.uuid = uuid;
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
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public org.joda.time.DateTime getSystemTime() {
		return systemTime;
	}

	@JsonProperty
	public void setSystemTime(org.joda.time.DateTime systemTime) {
		this.systemTime = systemTime;
	}

	@JsonProperty
	public String getOutcome() {
		return outcome;
	}

	@JsonProperty
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	@Override
	@JsonProperty
	public String[] getNotifiedListeners() {
		return notifiedListeners;
	}

	@Override
	@JsonProperty
	public void setNotifiedListeners(String[] listeners) {
		this.notifiedListeners = listeners;
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
