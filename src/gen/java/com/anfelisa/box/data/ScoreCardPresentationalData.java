package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class ScoreCardPresentationalData implements IScoreCardPresentationalData {
	
	@NotNull
	private String cardId;
	
	@NotEmpty
	private String given;
	
	@NotEmpty
	private String wanted;
	
	@NotNull
	private Integer maxPoints;
	
	@NotNull
	private String scheduledCardId;
	
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
	
	@NotNull
	private String scoredCardId;
	
	private org.joda.time.DateTime scheduledDateOfScored;
	
	private Integer quality;
	
	private Integer points;
	
	@NotNull
	private Integer submittedQuality;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	
	public ScoreCardPresentationalData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("maxPoints") Integer maxPoints,
		@JsonProperty("scheduledCardId") String scheduledCardId,
		@JsonProperty("ef") Float ef,
		@JsonProperty("interval") Integer interval,
		@JsonProperty("n") Integer n,
		@JsonProperty("count") Integer count,
		@JsonProperty("scheduledDate") org.joda.time.DateTime scheduledDate,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("lastQuality") Integer lastQuality,
		@JsonProperty("timestamp") org.joda.time.DateTime timestamp,
		@JsonProperty("removed") Boolean removed,
		@JsonProperty("scoredCardId") String scoredCardId,
		@JsonProperty("scheduledDateOfScored") org.joda.time.DateTime scheduledDateOfScored,
		@JsonProperty("quality") Integer quality,
		@JsonProperty("points") Integer points,
		@JsonProperty("submittedQuality") Integer submittedQuality,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
	) {
		this.cardId = cardId;
		this.given = given;
		this.wanted = wanted;
		this.maxPoints = maxPoints;
		this.scheduledCardId = scheduledCardId;
		this.ef = ef;
		this.interval = interval;
		this.n = n;
		this.count = count;
		this.scheduledDate = scheduledDate;
		this.boxId = boxId;
		this.lastQuality = lastQuality;
		this.timestamp = timestamp;
		this.removed = removed;
		this.scoredCardId = scoredCardId;
		this.scheduledDateOfScored = scheduledDateOfScored;
		this.quality = quality;
		this.points = points;
		this.submittedQuality = submittedQuality;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public ScoreCardPresentationalData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	public void setGiven(String given) {
		this.given = given;
	}
	public ScoreCardPresentationalData withGiven(String given) {
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
	public ScoreCardPresentationalData withWanted(String wanted) {
		this.wanted = wanted;
		return this;
	}
	
	@JsonProperty
	public Integer getMaxPoints() {
		return this.maxPoints;
	}
	public void setMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
	}
	public ScoreCardPresentationalData withMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
		return this;
	}
	
	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	public ScoreCardPresentationalData withScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
		return this;
	}
	
	@JsonProperty
	public Float getEf() {
		return this.ef;
	}
	public void setEf(Float ef) {
		this.ef = ef;
	}
	public ScoreCardPresentationalData withEf(Float ef) {
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
	public ScoreCardPresentationalData withInterval(Integer interval) {
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
	public ScoreCardPresentationalData withN(Integer n) {
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
	public ScoreCardPresentationalData withCount(Integer count) {
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
	public ScoreCardPresentationalData withScheduledDate(org.joda.time.DateTime scheduledDate) {
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
	public ScoreCardPresentationalData withBoxId(String boxId) {
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
	public ScoreCardPresentationalData withLastQuality(Integer lastQuality) {
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
	public ScoreCardPresentationalData withTimestamp(org.joda.time.DateTime timestamp) {
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
	public ScoreCardPresentationalData withRemoved(Boolean removed) {
		this.removed = removed;
		return this;
	}
	
	@JsonProperty
	public String getScoredCardId() {
		return this.scoredCardId;
	}
	public void setScoredCardId(String scoredCardId) {
		this.scoredCardId = scoredCardId;
	}
	public ScoreCardPresentationalData withScoredCardId(String scoredCardId) {
		this.scoredCardId = scoredCardId;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getScheduledDateOfScored() {
		return this.scheduledDateOfScored;
	}
	public void setScheduledDateOfScored(org.joda.time.DateTime scheduledDateOfScored) {
		this.scheduledDateOfScored = scheduledDateOfScored;
	}
	public ScoreCardPresentationalData withScheduledDateOfScored(org.joda.time.DateTime scheduledDateOfScored) {
		this.scheduledDateOfScored = scheduledDateOfScored;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality() {
		return this.quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	public ScoreCardPresentationalData withQuality(Integer quality) {
		this.quality = quality;
		return this;
	}
	
	@JsonProperty
	public Integer getPoints() {
		return this.points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public ScoreCardPresentationalData withPoints(Integer points) {
		this.points = points;
		return this;
	}
	
	@JsonProperty
	public Integer getSubmittedQuality() {
		return this.submittedQuality;
	}
	public void setSubmittedQuality(Integer submittedQuality) {
		this.submittedQuality = submittedQuality;
	}
	public ScoreCardPresentationalData withSubmittedQuality(Integer submittedQuality) {
		this.submittedQuality = submittedQuality;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public ScoreCardPresentationalData withCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsRole() {
		return this.credentialsRole;
	}
	public void setCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
	}
	public ScoreCardPresentationalData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
}

/*       S.D.G.       */
