package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IUserIdModel;
import com.anfelisa.box.models.IScoreReinforceCardModel;

@SuppressWarnings("all")
public class ScoreReinforceCardPresentationalData implements IScoreReinforceCardPresentationalData {
	
	@NotNull
	private String userId;
	
	@NotNull
	private String reinforceCardId;
	
	@NotNull
	private Integer quality;
	
	@NotNull
	private org.joda.time.DateTime changeDate;
	
	
	public ScoreReinforceCardPresentationalData(
		@JsonProperty("userId") String userId,
		@JsonProperty("reinforceCardId") String reinforceCardId,
		@JsonProperty("quality") Integer quality,
		@JsonProperty("changeDate") org.joda.time.DateTime changeDate
	) {
		this.userId = userId;
		this.reinforceCardId = reinforceCardId;
		this.quality = quality;
		this.changeDate = changeDate;
		
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ScoreReinforceCardPresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getReinforceCardId() {
		return this.reinforceCardId;
	}
	public void setReinforceCardId(String reinforceCardId) {
		this.reinforceCardId = reinforceCardId;
	}
	public ScoreReinforceCardPresentationalData withReinforceCardId(String reinforceCardId) {
		this.reinforceCardId = reinforceCardId;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality() {
		return this.quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	public ScoreReinforceCardPresentationalData withQuality(Integer quality) {
		this.quality = quality;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getChangeDate() {
		return this.changeDate;
	}
	public void setChangeDate(org.joda.time.DateTime changeDate) {
		this.changeDate = changeDate;
	}
	public ScoreReinforceCardPresentationalData withChangeDate(org.joda.time.DateTime changeDate) {
		this.changeDate = changeDate;
		return this;
	}
	
}

/*       S.D.G.       */
