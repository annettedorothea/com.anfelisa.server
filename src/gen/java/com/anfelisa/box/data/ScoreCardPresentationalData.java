package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IUserIdModel;
import com.anfelisa.box.models.IScoreCardModel;

@SuppressWarnings("all")
public class ScoreCardPresentationalData implements IScoreCardPresentationalData {
	
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
	
	
	public ScoreCardPresentationalData(
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
		@JsonProperty("scoredCardScoredDate") org.joda.time.DateTime scoredCardScoredDate
	) {
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
		
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ScoreCardPresentationalData withUserId(String userId) {
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
	public ScoreCardPresentationalData withCardId(String cardId) {
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
	public ScoreCardPresentationalData withBoxId(String boxId) {
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
	public ScoreCardPresentationalData withNextScheduledCardScheduledCardId(String nextScheduledCardScheduledCardId) {
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
	public ScoreCardPresentationalData withNextScheduledCardCreatedDate(org.joda.time.DateTime nextScheduledCardCreatedDate) {
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
	public ScoreCardPresentationalData withNextScheduledCardEf(Float nextScheduledCardEf) {
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
	public ScoreCardPresentationalData withNextScheduledCardInterval(Integer nextScheduledCardInterval) {
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
	public ScoreCardPresentationalData withNextScheduledCardN(Integer nextScheduledCardN) {
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
	public ScoreCardPresentationalData withNextScheduledCardCount(Integer nextScheduledCardCount) {
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
	public ScoreCardPresentationalData withNextScheduledCardScheduledDate(org.joda.time.DateTime nextScheduledCardScheduledDate) {
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
	public ScoreCardPresentationalData withNextScheduledCardLastQuality(Integer nextScheduledCardLastQuality) {
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
	public ScoreCardPresentationalData withScoredCardScheduledCardId(String scoredCardScheduledCardId) {
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
	public ScoreCardPresentationalData withScoredCardQuality(Integer scoredCardQuality) {
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
	public ScoreCardPresentationalData withScoredCardScoredDate(org.joda.time.DateTime scoredCardScoredDate) {
		this.scoredCardScoredDate = scoredCardScoredDate;
		return this;
	}
	
}

/*       S.D.G.       */
