/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class ScoreCardModel implements IScoreCardModel {

	private String cardId;
	
	private String nextScheduledCardScheduledCardId;
	
	private org.joda.time.DateTime nextScheduledCardCreatedDate;
	
	private Float nextScheduledCardEf;
	
	private Integer nextScheduledCardInterval;
	
	private Integer nextScheduledCardN;
	
	private Integer nextScheduledCardCount;
	
	private org.joda.time.DateTime nextScheduledCardScheduledDate;
	
	private Integer nextScheduledCardLastQuality;
	
	private String scoredCardScheduledCardId;
	
	private Integer scoredCardQuality;
	
	private org.joda.time.DateTime scoredCardScoredDate;
	
	private String reinforceCardId;
	
	private org.joda.time.DateTime reinforceCardCreatedDate;
	
	private String userId;
	
	private String boxId;
	

	public ScoreCardModel() {
	}

	public ScoreCardModel(
		@JsonProperty("cardId") String cardId,
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
		@JsonProperty("reinforceCardCreatedDate") org.joda.time.DateTime reinforceCardCreatedDate,
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId
	) {
		this.cardId = cardId;
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
		this.userId = userId;
		this.boxId = boxId;
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	@JsonProperty
	public String getNextScheduledCardScheduledCardId() {
		return this.nextScheduledCardScheduledCardId;
	}
	public void setNextScheduledCardScheduledCardId(String nextScheduledCardScheduledCardId) {
		this.nextScheduledCardScheduledCardId = nextScheduledCardScheduledCardId;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public org.joda.time.DateTime getNextScheduledCardCreatedDate() {
		return this.nextScheduledCardCreatedDate;
	}
	public void setNextScheduledCardCreatedDate(org.joda.time.DateTime nextScheduledCardCreatedDate) {
		this.nextScheduledCardCreatedDate = nextScheduledCardCreatedDate;
	}
	
	@JsonProperty
	public Float getNextScheduledCardEf() {
		return this.nextScheduledCardEf;
	}
	public void setNextScheduledCardEf(Float nextScheduledCardEf) {
		this.nextScheduledCardEf = nextScheduledCardEf;
	}
	
	@JsonProperty
	public Integer getNextScheduledCardInterval() {
		return this.nextScheduledCardInterval;
	}
	public void setNextScheduledCardInterval(Integer nextScheduledCardInterval) {
		this.nextScheduledCardInterval = nextScheduledCardInterval;
	}
	
	@JsonProperty
	public Integer getNextScheduledCardN() {
		return this.nextScheduledCardN;
	}
	public void setNextScheduledCardN(Integer nextScheduledCardN) {
		this.nextScheduledCardN = nextScheduledCardN;
	}
	
	@JsonProperty
	public Integer getNextScheduledCardCount() {
		return this.nextScheduledCardCount;
	}
	public void setNextScheduledCardCount(Integer nextScheduledCardCount) {
		this.nextScheduledCardCount = nextScheduledCardCount;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public org.joda.time.DateTime getNextScheduledCardScheduledDate() {
		return this.nextScheduledCardScheduledDate;
	}
	public void setNextScheduledCardScheduledDate(org.joda.time.DateTime nextScheduledCardScheduledDate) {
		this.nextScheduledCardScheduledDate = nextScheduledCardScheduledDate;
	}
	
	@JsonProperty
	public Integer getNextScheduledCardLastQuality() {
		return this.nextScheduledCardLastQuality;
	}
	public void setNextScheduledCardLastQuality(Integer nextScheduledCardLastQuality) {
		this.nextScheduledCardLastQuality = nextScheduledCardLastQuality;
	}
	
	@JsonProperty
	public String getScoredCardScheduledCardId() {
		return this.scoredCardScheduledCardId;
	}
	public void setScoredCardScheduledCardId(String scoredCardScheduledCardId) {
		this.scoredCardScheduledCardId = scoredCardScheduledCardId;
	}
	
	@JsonProperty
	public Integer getScoredCardQuality() {
		return this.scoredCardQuality;
	}
	public void setScoredCardQuality(Integer scoredCardQuality) {
		this.scoredCardQuality = scoredCardQuality;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public org.joda.time.DateTime getScoredCardScoredDate() {
		return this.scoredCardScoredDate;
	}
	public void setScoredCardScoredDate(org.joda.time.DateTime scoredCardScoredDate) {
		this.scoredCardScoredDate = scoredCardScoredDate;
	}
	
	@JsonProperty
	public String getReinforceCardId() {
		return this.reinforceCardId;
	}
	public void setReinforceCardId(String reinforceCardId) {
		this.reinforceCardId = reinforceCardId;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public org.joda.time.DateTime getReinforceCardCreatedDate() {
		return this.reinforceCardCreatedDate;
	}
	public void setReinforceCardCreatedDate(org.joda.time.DateTime reinforceCardCreatedDate) {
		this.reinforceCardCreatedDate = reinforceCardCreatedDate;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
}
	


/******* S.D.G. *******/



