package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.IScoredCardModel;
import com.anfelisa.box.models.ICardQualityModel;
import com.anfelisa.box.models.INowModel;
import com.anfelisa.user.models.ICredentialsModel;

@SuppressWarnings("unused")
public class ScoreCardData implements IScoreCardData {
	
	private String uuid;
	
	private String schema;
	
	private String createdId;
	
	@NotNull
	private Integer cardId;
	
	@NotEmpty
	private String content;
	
	@NotNull
	private Integer testId;
	
	@NotNull
	private String contentHash;
	
	@NotNull
	private Integer maxPoints;
	
	@NotNull
	private Integer scheduledCardId;
	
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
	private Integer boxId;
	
	private Integer lastQuality;
	
	@NotNull
	private org.joda.time.DateTime timestamp;
	
	@NotNull
	private Boolean removed;
	
	@NotNull
	private Integer scoredCardId;
	
	private org.joda.time.DateTime scheduledDateOfScored;
	
	private Integer quality;
	
	private Integer points;
	
	@NotNull
	private Integer submittedQuality;
	
	private org.joda.time.DateTime now;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	

	
	
	
	
	
	

	public ScoreCardData(
		@JsonProperty("cardId") Integer cardId,
		@JsonProperty("content") String content,
		@JsonProperty("testId") Integer testId,
		@JsonProperty("contentHash") String contentHash,
		@JsonProperty("maxPoints") Integer maxPoints,
		@JsonProperty("scheduledCardId") Integer scheduledCardId,
		@JsonProperty("ef") Float ef,
		@JsonProperty("interval") Integer interval,
		@JsonProperty("n") Integer n,
		@JsonProperty("count") Integer count,
		@JsonProperty("scheduledDate") org.joda.time.DateTime scheduledDate,
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("lastQuality") Integer lastQuality,
		@JsonProperty("timestamp") org.joda.time.DateTime timestamp,
		@JsonProperty("removed") Boolean removed,
		@JsonProperty("scoredCardId") Integer scoredCardId,
		@JsonProperty("scheduledDateOfScored") org.joda.time.DateTime scheduledDateOfScored,
		@JsonProperty("quality") Integer quality,
		@JsonProperty("points") Integer points,
		@JsonProperty("submittedQuality") Integer submittedQuality,
		@JsonProperty("now") org.joda.time.DateTime now,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.cardId = cardId;
		this.content = content;
		this.testId = testId;
		this.contentHash = contentHash;
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
		this.now = now;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.uuid = uuid;
		this.schema = schema;
	}

	public ScoreCardData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public Integer getCardId() {
		return this.cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public ScoreCardData withCardId(Integer cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ScoreCardData withContent(String content) {
		this.content = content;
		return this;
	}
	
	@JsonProperty
	public Integer getTestId() {
		return this.testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public ScoreCardData withTestId(Integer testId) {
		this.testId = testId;
		return this;
	}
	
	@JsonProperty
	public String getContentHash() {
		return this.contentHash;
	}
	public void setContentHash(String contentHash) {
		this.contentHash = contentHash;
	}
	public ScoreCardData withContentHash(String contentHash) {
		this.contentHash = contentHash;
		return this;
	}
	
	@JsonProperty
	public Integer getMaxPoints() {
		return this.maxPoints;
	}
	public void setMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
	}
	public ScoreCardData withMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
		return this;
	}
	
	@JsonProperty
	public Integer getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(Integer scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	public ScoreCardData withScheduledCardId(Integer scheduledCardId) {
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
	public ScoreCardData withEf(Float ef) {
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
	public ScoreCardData withInterval(Integer interval) {
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
	public ScoreCardData withN(Integer n) {
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
	public ScoreCardData withCount(Integer count) {
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
	public ScoreCardData withScheduledDate(org.joda.time.DateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
		return this;
	}
	
	@JsonProperty
	public Integer getBoxId() {
		return this.boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	public ScoreCardData withBoxId(Integer boxId) {
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
	public ScoreCardData withLastQuality(Integer lastQuality) {
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
	public ScoreCardData withTimestamp(org.joda.time.DateTime timestamp) {
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
	public ScoreCardData withRemoved(Boolean removed) {
		this.removed = removed;
		return this;
	}
	
	@JsonProperty
	public Integer getScoredCardId() {
		return this.scoredCardId;
	}
	public void setScoredCardId(Integer scoredCardId) {
		this.scoredCardId = scoredCardId;
	}
	public ScoreCardData withScoredCardId(Integer scoredCardId) {
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
	public ScoreCardData withScheduledDateOfScored(org.joda.time.DateTime scheduledDateOfScored) {
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
	public ScoreCardData withQuality(Integer quality) {
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
	public ScoreCardData withPoints(Integer points) {
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
	public ScoreCardData withSubmittedQuality(Integer submittedQuality) {
		this.submittedQuality = submittedQuality;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getNow() {
		return this.now;
	}
	public void setNow(org.joda.time.DateTime now) {
		this.now = now;
	}
	public ScoreCardData withNow(org.joda.time.DateTime now) {
		this.now = now;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public ScoreCardData withCredentialsUsername(String credentialsUsername) {
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
	public ScoreCardData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
	
	
	
	
	
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}

	@JsonIgnore
	public String getCreatedId() {
		return createdId;
	}

	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

}

/*       S.D.G.       */
