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
import com.anfelisa.user.models.ICredentialsModel;

@SuppressWarnings("all")
public class ScoreCardData implements IScoreCardData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	@NotNull
	private String cardId;
	
	@NotEmpty
	private String content;
	
	@NotNull
	private String testId;
	
	@NotNull
	private String contentHash;
	
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
	

	private org.joda.time.DateTime systemTime;
	
	public ScoreCardData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("content") String content,
		@JsonProperty("testId") String testId,
		@JsonProperty("contentHash") String contentHash,
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
,		@JsonProperty("uuid") String uuid
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
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.uuid = uuid;
		
	}

	public ScoreCardData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public ScoreCardData withCardId(String cardId) {
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
	public String getTestId() {
		return this.testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public ScoreCardData withTestId(String testId) {
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
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	public ScoreCardData withScheduledCardId(String scheduledCardId) {
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
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public ScoreCardData withBoxId(String boxId) {
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
	public String getScoredCardId() {
		return this.scoredCardId;
	}
	public void setScoredCardId(String scoredCardId) {
		this.scoredCardId = scoredCardId;
	}
	public ScoreCardData withScoredCardId(String scoredCardId) {
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
		return new ScoreCardPresentationalData(
			this.cardId,
			this.content,
			this.testId,
			this.contentHash,
			this.maxPoints,
			this.scheduledCardId,
			this.ef,
			this.interval,
			this.n,
			this.count,
			this.scheduledDate,
			this.boxId,
			this.lastQuality,
			this.timestamp,
			this.removed,
			this.scoredCardId,
			this.scheduledDateOfScored,
			this.quality,
			this.points,
			this.submittedQuality,
			this.credentialsUsername,
			this.credentialsRole
		);
	}

}

/*       S.D.G.       */
