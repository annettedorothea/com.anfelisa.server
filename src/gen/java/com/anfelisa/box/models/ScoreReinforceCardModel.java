/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class ScoreReinforceCardModel implements IScoreReinforceCardModel {

	private String reinforceCardId;

	private Integer scoredCardQuality;

	private java.time.LocalDateTime changeDate;

	private String userId;


	public ScoreReinforceCardModel() {
	}

	public ScoreReinforceCardModel(
		@JsonProperty("reinforceCardId") String reinforceCardId,
		@JsonProperty("scoredCardQuality") Integer scoredCardQuality,
		@JsonProperty("changeDate") java.time.LocalDateTime changeDate,
		@JsonProperty("userId") String userId
	) {
		this.reinforceCardId = reinforceCardId;
		this.scoredCardQuality = scoredCardQuality;
		this.changeDate = changeDate;
		this.userId = userId;
	}

	@JsonProperty
	public String getReinforceCardId() {
		return this.reinforceCardId;
	}
	public void setReinforceCardId(String reinforceCardId) {
		this.reinforceCardId = reinforceCardId;
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
	public java.time.LocalDateTime getChangeDate() {
		return this.changeDate;
	}
	public void setChangeDate(java.time.LocalDateTime changeDate) {
		this.changeDate = changeDate;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}



/******* S.D.G. *******/



