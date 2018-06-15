package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

public class NextReinforceCardData extends AbstractData implements INextReinforceCardData {
	
	@NotNull
	private String userId;
	
	@NotNull
	private String reinforceCardId;
	
	@NotNull
	private org.joda.time.DateTime changeDate;
	
	private Integer lastQuality;
	
	private String given;
	
	private String wanted;
	
	private String image;
	
	@NotNull
	private String boxId;
	

	public NextReinforceCardData(
		@JsonProperty("userId") String userId,
		@JsonProperty("reinforceCardId") String reinforceCardId,
		@JsonProperty("changeDate") org.joda.time.DateTime changeDate,
		@JsonProperty("lastQuality") Integer lastQuality,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("image") String image,
		@JsonProperty("boxId") String boxId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.reinforceCardId = reinforceCardId;
		this.changeDate = changeDate;
		this.lastQuality = lastQuality;
		this.given = given;
		this.wanted = wanted;
		this.image = image;
		this.boxId = boxId;
	}

	public NextReinforceCardData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public NextReinforceCardData withUserId(String userId) {
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
	public NextReinforceCardData withReinforceCardId(String reinforceCardId) {
		this.reinforceCardId = reinforceCardId;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getChangeDate() {
		return this.changeDate;
	}
	public void setChangeDate(org.joda.time.DateTime changeDate) {
		this.changeDate = changeDate;
	}
	public NextReinforceCardData withChangeDate(org.joda.time.DateTime changeDate) {
		this.changeDate = changeDate;
		return this;
	}
	
	@JsonProperty
	public Integer getLastQuality() {
		return this.lastQuality;
	}
	public void setLastQuality(Integer lastQuality) {
		this.lastQuality = lastQuality;
	}
	public NextReinforceCardData withLastQuality(Integer lastQuality) {
		this.lastQuality = lastQuality;
		return this;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	public void setGiven(String given) {
		this.given = given;
	}
	public NextReinforceCardData withGiven(String given) {
		this.given = given;
		return this;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	public void setWanted(String wanted) {
		this.wanted = wanted;
	}
	public NextReinforceCardData withWanted(String wanted) {
		this.wanted = wanted;
		return this;
	}
	
	@JsonProperty
	public String getImage() {
		return this.image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public NextReinforceCardData withImage(String image) {
		this.image = image;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public NextReinforceCardData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new NextReinforceCardPresentationalData(
			this.userId,
			this.reinforceCardId,
			this.changeDate,
			this.lastQuality,
			this.given,
			this.wanted,
			this.image,
			this.boxId
		);
	}

}

/*       S.D.G.       */
