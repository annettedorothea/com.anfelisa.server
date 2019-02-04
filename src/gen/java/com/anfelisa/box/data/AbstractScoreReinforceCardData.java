package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.IScoreReinforceCardModel;

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
	
	
	
	public List<String> equalsPrimitiveTypes(IScoreReinforceCardModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getReinforceCardId() == null && other.getReinforceCardId() == null) && !this.getReinforceCardId().equals(other.getReinforceCardId())) {
			differingAttributes.add("reinforceCardId: " + this.getReinforceCardId() + " " + other.getReinforceCardId());
		}
		if (!(this.getQuality() == null && other.getQuality() == null) && !this.getQuality().equals(other.getQuality())) {
			differingAttributes.add("quality: " + this.getQuality() + " " + other.getQuality());
		}
		if (!(this.getChangeDate() == null && other.getChangeDate() == null) && !this.getChangeDate().equals(other.getChangeDate())) {
			differingAttributes.add("changeDate: " + this.getChangeDate() + " " + other.getChangeDate());
		}
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		return differingAttributes;
	}
	
	
}

/*       S.D.G.       */
