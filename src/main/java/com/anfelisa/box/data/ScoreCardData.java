package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoreCardData extends AbstractData implements IScoreCardData {
	
	@NotNull
	private String userId;
	
	@NotNull
	private String cardId;
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String nextScheduledCardScheduledCardId;
	
	@NotNull
	private org.joda.time.DateTime nextScheduledCardCreatedDate;
	
	@NotNull
	private Float nextScheduledCardEf;
	
	private Integer nextScheduledCardInterval;
	
	@NotNull
	private Integer nextScheduledCardN;
	
	@NotNull
	private Integer nextScheduledCardCount;
	
	@NotNull
	private org.joda.time.DateTime nextScheduledCardScheduledDate;
	
	private Integer nextScheduledCardLastQuality;
	
	@NotNull
	private String scoredCardScheduledCardId;
	
	private Integer scoredCardQuality;
	
	private org.joda.time.DateTime scoredCardScoredDate;
	
	@NotNull
	private String reinforceCardId;
	
	@NotNull
	private org.joda.time.DateTime reinforceCardCreatedDate;
	

	public ScoreCardData(
		@JsonProperty("userId") String userId,
		@JsonProperty("cardId") String cardId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("nextScheduledCardScheduledCardId") String nextScheduledCardScheduledCardId,
		@JsonProperty("nextScheduledCardCreatedDate") org.joda.time.DateTime nextScheduledCardCreatedDate,
		@JsonProperty("nextScheduledCardEf") Float nextScheduledCardEf,
		@JsonProperty("nextScheduledCardInterval") Integer nextScheduledCardInterval,
		@JsonProperty("nextScheduledCardN") Integer nextScheduledCardN,
		@JsonProperty("nextScheduledCardCount") Integer nextScheduledCardCount,
		@JsonProperty("nextScheduledCardScheduledDate") org.joda.time.DateTime nextScheduledCardScheduledDate,
		@JsonProperty("nextScheduledCardLastQuality") Integer nextScheduledCardLastQuality,
		@JsonProperty("scoredCardScheduledCardId") String scoredCardScheduledCardId,
		@JsonProperty("scoredCardQuality") Integer scoredCardQuality,
		@JsonProperty("scoredCardScoredDate") org.joda.time.DateTime scoredCardScoredDate,
		@JsonProperty("reinforceCardId") String reinforceCardId,
		@JsonProperty("reinforceCardCreatedDate") org.joda.time.DateTime reinforceCardCreatedDate
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.cardId = cardId;
		this.boxId = boxId;
		this.nextScheduledCardScheduledCardId = nextScheduledCardScheduledCardId;
		this.nextScheduledCardCreatedDate = nextScheduledCardCreatedDate;
		this.nextScheduledCardEf = nextScheduledCardEf;
		this.nextScheduledCardInterval = nextScheduledCardInterval;
		this.nextScheduledCardN = nextScheduledCardN;
		this.nextScheduledCardCount = nextScheduledCardCount;
		this.nextScheduledCardScheduledDate = nextScheduledCardScheduledDate;
		this.nextScheduledCardLastQuality = nextScheduledCardLastQuality;
		this.scoredCardScheduledCardId = scoredCardScheduledCardId;
		this.scoredCardQuality = scoredCardQuality;
		this.scoredCardScoredDate = scoredCardScoredDate;
		this.reinforceCardId = reinforceCardId;
		this.reinforceCardCreatedDate = reinforceCardCreatedDate;
	}

	public ScoreCardData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ScoreCardData withUserId(String userId) {
		this.userId = userId;
		return this;
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
	public String getNextScheduledCardScheduledCardId() {
		return this.nextScheduledCardScheduledCardId;
	}
	public void setNextScheduledCardScheduledCardId(String nextScheduledCardScheduledCardId) {
		this.nextScheduledCardScheduledCardId = nextScheduledCardScheduledCardId;
	}
	public ScoreCardData withNextScheduledCardScheduledCardId(String nextScheduledCardScheduledCardId) {
		this.nextScheduledCardScheduledCardId = nextScheduledCardScheduledCardId;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getNextScheduledCardCreatedDate() {
		return this.nextScheduledCardCreatedDate;
	}
	public void setNextScheduledCardCreatedDate(org.joda.time.DateTime nextScheduledCardCreatedDate) {
		this.nextScheduledCardCreatedDate = nextScheduledCardCreatedDate;
	}
	public ScoreCardData withNextScheduledCardCreatedDate(org.joda.time.DateTime nextScheduledCardCreatedDate) {
		this.nextScheduledCardCreatedDate = nextScheduledCardCreatedDate;
		return this;
	}
	
	@JsonProperty
	public Float getNextScheduledCardEf() {
		return this.nextScheduledCardEf;
	}
	public void setNextScheduledCardEf(Float nextScheduledCardEf) {
		this.nextScheduledCardEf = nextScheduledCardEf;
	}
	public ScoreCardData withNextScheduledCardEf(Float nextScheduledCardEf) {
		this.nextScheduledCardEf = nextScheduledCardEf;
		return this;
	}
	
	@JsonProperty
	public Integer getNextScheduledCardInterval() {
		return this.nextScheduledCardInterval;
	}
	public void setNextScheduledCardInterval(Integer nextScheduledCardInterval) {
		this.nextScheduledCardInterval = nextScheduledCardInterval;
	}
	public ScoreCardData withNextScheduledCardInterval(Integer nextScheduledCardInterval) {
		this.nextScheduledCardInterval = nextScheduledCardInterval;
		return this;
	}
	
	@JsonProperty
	public Integer getNextScheduledCardN() {
		return this.nextScheduledCardN;
	}
	public void setNextScheduledCardN(Integer nextScheduledCardN) {
		this.nextScheduledCardN = nextScheduledCardN;
	}
	public ScoreCardData withNextScheduledCardN(Integer nextScheduledCardN) {
		this.nextScheduledCardN = nextScheduledCardN;
		return this;
	}
	
	@JsonProperty
	public Integer getNextScheduledCardCount() {
		return this.nextScheduledCardCount;
	}
	public void setNextScheduledCardCount(Integer nextScheduledCardCount) {
		this.nextScheduledCardCount = nextScheduledCardCount;
	}
	public ScoreCardData withNextScheduledCardCount(Integer nextScheduledCardCount) {
		this.nextScheduledCardCount = nextScheduledCardCount;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getNextScheduledCardScheduledDate() {
		return this.nextScheduledCardScheduledDate;
	}
	public void setNextScheduledCardScheduledDate(org.joda.time.DateTime nextScheduledCardScheduledDate) {
		this.nextScheduledCardScheduledDate = nextScheduledCardScheduledDate;
	}
	public ScoreCardData withNextScheduledCardScheduledDate(org.joda.time.DateTime nextScheduledCardScheduledDate) {
		this.nextScheduledCardScheduledDate = nextScheduledCardScheduledDate;
		return this;
	}
	
	@JsonProperty
	public Integer getNextScheduledCardLastQuality() {
		return this.nextScheduledCardLastQuality;
	}
	public void setNextScheduledCardLastQuality(Integer nextScheduledCardLastQuality) {
		this.nextScheduledCardLastQuality = nextScheduledCardLastQuality;
	}
	public ScoreCardData withNextScheduledCardLastQuality(Integer nextScheduledCardLastQuality) {
		this.nextScheduledCardLastQuality = nextScheduledCardLastQuality;
		return this;
	}
	
	@JsonProperty
	public String getScoredCardScheduledCardId() {
		return this.scoredCardScheduledCardId;
	}
	public void setScoredCardScheduledCardId(String scoredCardScheduledCardId) {
		this.scoredCardScheduledCardId = scoredCardScheduledCardId;
	}
	public ScoreCardData withScoredCardScheduledCardId(String scoredCardScheduledCardId) {
		this.scoredCardScheduledCardId = scoredCardScheduledCardId;
		return this;
	}
	
	@JsonProperty
	public Integer getScoredCardQuality() {
		return this.scoredCardQuality;
	}
	public void setScoredCardQuality(Integer scoredCardQuality) {
		this.scoredCardQuality = scoredCardQuality;
	}
	public ScoreCardData withScoredCardQuality(Integer scoredCardQuality) {
		this.scoredCardQuality = scoredCardQuality;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getScoredCardScoredDate() {
		return this.scoredCardScoredDate;
	}
	public void setScoredCardScoredDate(org.joda.time.DateTime scoredCardScoredDate) {
		this.scoredCardScoredDate = scoredCardScoredDate;
	}
	public ScoreCardData withScoredCardScoredDate(org.joda.time.DateTime scoredCardScoredDate) {
		this.scoredCardScoredDate = scoredCardScoredDate;
		return this;
	}
	
	@JsonProperty
	public String getReinforceCardId() {
		return this.reinforceCardId;
	}
	public void setReinforceCardId(String reinforceCardId) {
		this.reinforceCardId = reinforceCardId;
	}
	public ScoreCardData withReinforceCardId(String reinforceCardId) {
		this.reinforceCardId = reinforceCardId;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getReinforceCardCreatedDate() {
		return this.reinforceCardCreatedDate;
	}
	public void setReinforceCardCreatedDate(org.joda.time.DateTime reinforceCardCreatedDate) {
		this.reinforceCardCreatedDate = reinforceCardCreatedDate;
	}
	public ScoreCardData withReinforceCardCreatedDate(org.joda.time.DateTime reinforceCardCreatedDate) {
		this.reinforceCardCreatedDate = reinforceCardCreatedDate;
		return this;
	}
	

}

/*       S.D.G.       */
