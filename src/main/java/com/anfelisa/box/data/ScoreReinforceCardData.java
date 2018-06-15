package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

public class ScoreReinforceCardData extends AbstractData implements IScoreReinforceCardData {
	
	@NotNull
	private String userId;
	
	@NotNull
	private String reinforceCardId;
	
	@NotNull
	private Integer quality;
	
	@NotNull
	private org.joda.time.DateTime changeDate;
	

	public ScoreReinforceCardData(
		@JsonProperty("userId") String userId,
		@JsonProperty("reinforceCardId") String reinforceCardId,
		@JsonProperty("quality") Integer quality,
		@JsonProperty("changeDate") org.joda.time.DateTime changeDate
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.reinforceCardId = reinforceCardId;
		this.quality = quality;
		this.changeDate = changeDate;
	}

	public ScoreReinforceCardData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ScoreReinforceCardData withUserId(String userId) {
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
	public ScoreReinforceCardData withReinforceCardId(String reinforceCardId) {
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
	public ScoreReinforceCardData withQuality(Integer quality) {
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
	public ScoreReinforceCardData withChangeDate(org.joda.time.DateTime changeDate) {
		this.changeDate = changeDate;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new ScoreReinforceCardPresentationalData(
			this.userId,
			this.reinforceCardId,
			this.quality,
			this.changeDate
		);
	}

}

/*       S.D.G.       */
