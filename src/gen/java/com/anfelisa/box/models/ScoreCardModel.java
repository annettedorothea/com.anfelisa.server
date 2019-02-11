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
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ScoreCardModel implements IScoreCardModel {

	@NotNull
	private String cardId;
	
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
	
	private String userId;
	
	@NotNull
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
	
	
	public List<String> equalsPrimitiveTypes(com.anfelisa.box.models.IScoreCardModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getCardId() == null && other.getCardId() == null) && !this.getCardId().equals(other.getCardId())) {
			differingAttributes.add("cardId: " + this.getCardId() + " " + other.getCardId());
		}
		if (!(this.getNextScheduledCardScheduledCardId() == null && other.getNextScheduledCardScheduledCardId() == null) && !this.getNextScheduledCardScheduledCardId().equals(other.getNextScheduledCardScheduledCardId())) {
			differingAttributes.add("nextScheduledCardScheduledCardId: " + this.getNextScheduledCardScheduledCardId() + " " + other.getNextScheduledCardScheduledCardId());
		}
		if (!(this.getNextScheduledCardCreatedDate() == null && other.getNextScheduledCardCreatedDate() == null) && !this.getNextScheduledCardCreatedDate().equals(other.getNextScheduledCardCreatedDate())) {
			differingAttributes.add("nextScheduledCardCreatedDate: " + this.getNextScheduledCardCreatedDate() + " " + other.getNextScheduledCardCreatedDate());
		}
		if (!(this.getNextScheduledCardEf() == null && other.getNextScheduledCardEf() == null) && !this.getNextScheduledCardEf().equals(other.getNextScheduledCardEf())) {
			differingAttributes.add("nextScheduledCardEf: " + this.getNextScheduledCardEf() + " " + other.getNextScheduledCardEf());
		}
		if (!(this.getNextScheduledCardInterval() == null && other.getNextScheduledCardInterval() == null) && !this.getNextScheduledCardInterval().equals(other.getNextScheduledCardInterval())) {
			differingAttributes.add("nextScheduledCardInterval: " + this.getNextScheduledCardInterval() + " " + other.getNextScheduledCardInterval());
		}
		if (!(this.getNextScheduledCardN() == null && other.getNextScheduledCardN() == null) && !this.getNextScheduledCardN().equals(other.getNextScheduledCardN())) {
			differingAttributes.add("nextScheduledCardN: " + this.getNextScheduledCardN() + " " + other.getNextScheduledCardN());
		}
		if (!(this.getNextScheduledCardCount() == null && other.getNextScheduledCardCount() == null) && !this.getNextScheduledCardCount().equals(other.getNextScheduledCardCount())) {
			differingAttributes.add("nextScheduledCardCount: " + this.getNextScheduledCardCount() + " " + other.getNextScheduledCardCount());
		}
		if (!(this.getNextScheduledCardScheduledDate() == null && other.getNextScheduledCardScheduledDate() == null) && !this.getNextScheduledCardScheduledDate().equals(other.getNextScheduledCardScheduledDate())) {
			differingAttributes.add("nextScheduledCardScheduledDate: " + this.getNextScheduledCardScheduledDate() + " " + other.getNextScheduledCardScheduledDate());
		}
		if (!(this.getNextScheduledCardLastQuality() == null && other.getNextScheduledCardLastQuality() == null) && !this.getNextScheduledCardLastQuality().equals(other.getNextScheduledCardLastQuality())) {
			differingAttributes.add("nextScheduledCardLastQuality: " + this.getNextScheduledCardLastQuality() + " " + other.getNextScheduledCardLastQuality());
		}
		if (!(this.getScoredCardScheduledCardId() == null && other.getScoredCardScheduledCardId() == null) && !this.getScoredCardScheduledCardId().equals(other.getScoredCardScheduledCardId())) {
			differingAttributes.add("scoredCardScheduledCardId: " + this.getScoredCardScheduledCardId() + " " + other.getScoredCardScheduledCardId());
		}
		if (!(this.getScoredCardQuality() == null && other.getScoredCardQuality() == null) && !this.getScoredCardQuality().equals(other.getScoredCardQuality())) {
			differingAttributes.add("scoredCardQuality: " + this.getScoredCardQuality() + " " + other.getScoredCardQuality());
		}
		if (!(this.getScoredCardScoredDate() == null && other.getScoredCardScoredDate() == null) && !this.getScoredCardScoredDate().equals(other.getScoredCardScoredDate())) {
			differingAttributes.add("scoredCardScoredDate: " + this.getScoredCardScoredDate() + " " + other.getScoredCardScoredDate());
		}
		if (!(this.getReinforceCardId() == null && other.getReinforceCardId() == null) && !this.getReinforceCardId().equals(other.getReinforceCardId())) {
			differingAttributes.add("reinforceCardId: " + this.getReinforceCardId() + " " + other.getReinforceCardId());
		}
		if (!(this.getReinforceCardCreatedDate() == null && other.getReinforceCardCreatedDate() == null) && !this.getReinforceCardCreatedDate().equals(other.getReinforceCardCreatedDate())) {
			differingAttributes.add("reinforceCardCreatedDate: " + this.getReinforceCardCreatedDate() + " " + other.getReinforceCardCreatedDate());
		}
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		if (!(this.getBoxId() == null && other.getBoxId() == null) && !this.getBoxId().equals(other.getBoxId())) {
			differingAttributes.add("boxId: " + this.getBoxId() + " " + other.getBoxId());
		}
		return differingAttributes;
	}
	
}




/******* S.D.G. *******/



