package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractScoreReinforceCardData extends AbstractData implements IScoreReinforceCardData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractScoreReinforceCardData.class);
	
	@NotNull
	private String reinforceCardId;
	
	@NotNull
	private Integer quality;
	
	@NotNull
	private org.joda.time.DateTime changeDate;
	
	private String userId;
	

	public AbstractScoreReinforceCardData(
		@JsonProperty("reinforceCardId") String reinforceCardId,
		@JsonProperty("quality") Integer quality,
		@JsonProperty("changeDate") org.joda.time.DateTime changeDate,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.reinforceCardId = reinforceCardId;
		this.quality = quality;
		this.changeDate = changeDate;
		this.userId = userId;
	}

	public AbstractScoreReinforceCardData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getReinforceCardId() {
		return this.reinforceCardId;
	}
	public void setReinforceCardId(String reinforceCardId) {
		this.reinforceCardId = reinforceCardId;
	}
	public IScoreReinforceCardData withReinforceCardId(String reinforceCardId) {
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
	public IScoreReinforceCardData withQuality(Integer quality) {
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
	public IScoreReinforceCardData withChangeDate(org.joda.time.DateTime changeDate) {
		this.changeDate = changeDate;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IScoreReinforceCardData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
}

/*       S.D.G.       */
