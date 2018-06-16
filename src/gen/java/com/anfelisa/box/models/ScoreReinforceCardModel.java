package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ScoreReinforceCardModel implements IScoreReinforceCardModel {

	@NotNull
	private String reinforceCardId;
	
	@NotNull
	private Integer quality;
	
	@NotNull
	private org.joda.time.DateTime changeDate;
	

	public ScoreReinforceCardModel(
		@JsonProperty("reinforceCardId") String reinforceCardId,
		@JsonProperty("quality") Integer quality,
		@JsonProperty("changeDate") org.joda.time.DateTime changeDate
	) {
		this.reinforceCardId = reinforceCardId;
		this.quality = quality;
		this.changeDate = changeDate;
	}

	@JsonProperty
	public String getReinforceCardId() {
		return this.reinforceCardId;
	}
	public void setReinforceCardId(String reinforceCardId) {
		this.reinforceCardId = reinforceCardId;
	}
	
	@JsonProperty
	public Integer getQuality() {
		return this.quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getChangeDate() {
		return this.changeDate;
	}
	public void setChangeDate(org.joda.time.DateTime changeDate) {
		this.changeDate = changeDate;
	}
	

}

/*       S.D.G.       */
