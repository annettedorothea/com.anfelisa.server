/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.IScoreCardModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractScoreCardData extends AbstractData implements IScoreCardData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractScoreCardData.class);
	
	private String cardId;
	
	private String nextScheduledCardScheduledCardId;
	
	private java.time.LocalDateTime nextScheduledCardCreatedDate;
	
	private Float nextScheduledCardEf;
	
	private Integer nextScheduledCardInterval;
	
	private Integer nextScheduledCardN;
	
	private Integer nextScheduledCardCount;
	
	private java.time.LocalDateTime nextScheduledCardScheduledDate;
	
	private Integer nextScheduledCardLastQuality;
	
	private String scheduledCardId;
	
	private Integer scoredCardQuality;
	
	private java.time.LocalDateTime scoredCardScoredDate;
	
	private String reinforceCardId;
	
	private java.time.LocalDateTime reinforceCardCreatedDate;
	
	private String userId;
	
	private String boxId;
	

	public AbstractScoreCardData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("nextScheduledCardScheduledCardId") String nextScheduledCardScheduledCardId,
		@JsonProperty("nextScheduledCardCreatedDate") java.time.LocalDateTime nextScheduledCardCreatedDate,
		@JsonProperty("nextScheduledCardEf") Float nextScheduledCardEf,
		@JsonProperty("nextScheduledCardInterval") Integer nextScheduledCardInterval,
		@JsonProperty("nextScheduledCardN") Integer nextScheduledCardN,
		@JsonProperty("nextScheduledCardCount") Integer nextScheduledCardCount,
		@JsonProperty("nextScheduledCardScheduledDate") java.time.LocalDateTime nextScheduledCardScheduledDate,
		@JsonProperty("nextScheduledCardLastQuality") Integer nextScheduledCardLastQuality,
		@JsonProperty("scheduledCardId") String scheduledCardId,
		@JsonProperty("scoredCardQuality") Integer scoredCardQuality,
		@JsonProperty("scoredCardScoredDate") java.time.LocalDateTime scoredCardScoredDate,
		@JsonProperty("reinforceCardId") String reinforceCardId,
		@JsonProperty("reinforceCardCreatedDate") java.time.LocalDateTime reinforceCardCreatedDate,
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.cardId = cardId;
		this.nextScheduledCardScheduledCardId = nextScheduledCardScheduledCardId;
		this.nextScheduledCardCreatedDate = nextScheduledCardCreatedDate;
		this.nextScheduledCardEf = nextScheduledCardEf;
		this.nextScheduledCardInterval = nextScheduledCardInterval;
		this.nextScheduledCardN = nextScheduledCardN;
		this.nextScheduledCardCount = nextScheduledCardCount;
		this.nextScheduledCardScheduledDate = nextScheduledCardScheduledDate;
		this.nextScheduledCardLastQuality = nextScheduledCardLastQuality;
		this.scheduledCardId = scheduledCardId;
		this.scoredCardQuality = scoredCardQuality;
		this.scoredCardScoredDate = scoredCardScoredDate;
		this.reinforceCardId = reinforceCardId;
		this.reinforceCardCreatedDate = reinforceCardCreatedDate;
		this.userId = userId;
		this.boxId = boxId;
	}

	public AbstractScoreCardData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public IScoreCardData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public String getNextScheduledCardScheduledCardId() {
		return this.nextScheduledCardScheduledCardId;
	}
	public void setNextScheduledCardScheduledCardId(String nextScheduledCardScheduledCardId) {
		this.nextScheduledCardScheduledCardId = nextScheduledCardScheduledCardId;
	}
	public IScoreCardData withNextScheduledCardScheduledCardId(String nextScheduledCardScheduledCardId) {
		this.nextScheduledCardScheduledCardId = nextScheduledCardScheduledCardId;
		return this;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public java.time.LocalDateTime getNextScheduledCardCreatedDate() {
		return this.nextScheduledCardCreatedDate;
	}
	public void setNextScheduledCardCreatedDate(java.time.LocalDateTime nextScheduledCardCreatedDate) {
		this.nextScheduledCardCreatedDate = nextScheduledCardCreatedDate;
	}
	public IScoreCardData withNextScheduledCardCreatedDate(java.time.LocalDateTime nextScheduledCardCreatedDate) {
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
	public IScoreCardData withNextScheduledCardEf(Float nextScheduledCardEf) {
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
	public IScoreCardData withNextScheduledCardInterval(Integer nextScheduledCardInterval) {
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
	public IScoreCardData withNextScheduledCardN(Integer nextScheduledCardN) {
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
	public IScoreCardData withNextScheduledCardCount(Integer nextScheduledCardCount) {
		this.nextScheduledCardCount = nextScheduledCardCount;
		return this;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public java.time.LocalDateTime getNextScheduledCardScheduledDate() {
		return this.nextScheduledCardScheduledDate;
	}
	public void setNextScheduledCardScheduledDate(java.time.LocalDateTime nextScheduledCardScheduledDate) {
		this.nextScheduledCardScheduledDate = nextScheduledCardScheduledDate;
	}
	public IScoreCardData withNextScheduledCardScheduledDate(java.time.LocalDateTime nextScheduledCardScheduledDate) {
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
	public IScoreCardData withNextScheduledCardLastQuality(Integer nextScheduledCardLastQuality) {
		this.nextScheduledCardLastQuality = nextScheduledCardLastQuality;
		return this;
	}
	
	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	public IScoreCardData withScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
		return this;
	}
	
	@JsonProperty
	public Integer getScoredCardQuality() {
		return this.scoredCardQuality;
	}
	public void setScoredCardQuality(Integer scoredCardQuality) {
		this.scoredCardQuality = scoredCardQuality;
	}
	public IScoreCardData withScoredCardQuality(Integer scoredCardQuality) {
		this.scoredCardQuality = scoredCardQuality;
		return this;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public java.time.LocalDateTime getScoredCardScoredDate() {
		return this.scoredCardScoredDate;
	}
	public void setScoredCardScoredDate(java.time.LocalDateTime scoredCardScoredDate) {
		this.scoredCardScoredDate = scoredCardScoredDate;
	}
	public IScoreCardData withScoredCardScoredDate(java.time.LocalDateTime scoredCardScoredDate) {
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
	public IScoreCardData withReinforceCardId(String reinforceCardId) {
		this.reinforceCardId = reinforceCardId;
		return this;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public java.time.LocalDateTime getReinforceCardCreatedDate() {
		return this.reinforceCardCreatedDate;
	}
	public void setReinforceCardCreatedDate(java.time.LocalDateTime reinforceCardCreatedDate) {
		this.reinforceCardCreatedDate = reinforceCardCreatedDate;
	}
	public IScoreCardData withReinforceCardCreatedDate(java.time.LocalDateTime reinforceCardCreatedDate) {
		this.reinforceCardCreatedDate = reinforceCardCreatedDate;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IScoreCardData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IScoreCardData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	
	
	public IScoreCardData deepCopy() {
		IScoreCardData copy = new ScoreCardData(this.getUuid());
		copy.setCardId(this.getCardId());
		copy.setNextScheduledCardScheduledCardId(this.getNextScheduledCardScheduledCardId());
		copy.setNextScheduledCardCreatedDate(this.getNextScheduledCardCreatedDate());
		copy.setNextScheduledCardEf(this.getNextScheduledCardEf());
		copy.setNextScheduledCardInterval(this.getNextScheduledCardInterval());
		copy.setNextScheduledCardN(this.getNextScheduledCardN());
		copy.setNextScheduledCardCount(this.getNextScheduledCardCount());
		copy.setNextScheduledCardScheduledDate(this.getNextScheduledCardScheduledDate());
		copy.setNextScheduledCardLastQuality(this.getNextScheduledCardLastQuality());
		copy.setScheduledCardId(this.getScheduledCardId());
		copy.setScoredCardQuality(this.getScoredCardQuality());
		copy.setScoredCardScoredDate(this.getScoredCardScoredDate());
		copy.setReinforceCardId(this.getReinforceCardId());
		copy.setReinforceCardCreatedDate(this.getReinforceCardCreatedDate());
		copy.setUserId(this.getUserId());
		copy.setBoxId(this.getBoxId());
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



