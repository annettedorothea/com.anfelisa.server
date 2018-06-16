package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class NextReinforceCardModel implements INextReinforceCardModel {

	@NotNull
	private String reinforceCardId;
	
	@NotNull
	private org.joda.time.DateTime changeDate;
	
	private Integer lastQuality;
	
	private String given;
	
	private String wanted;
	
	private String image;
	

	public NextReinforceCardModel(
		@JsonProperty("reinforceCardId") String reinforceCardId,
		@JsonProperty("changeDate") org.joda.time.DateTime changeDate,
		@JsonProperty("lastQuality") Integer lastQuality,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("image") String image
	) {
		this.reinforceCardId = reinforceCardId;
		this.changeDate = changeDate;
		this.lastQuality = lastQuality;
		this.given = given;
		this.wanted = wanted;
		this.image = image;
	}

	@JsonProperty
	public String getReinforceCardId() {
		return this.reinforceCardId;
	}
	public void setReinforceCardId(String reinforceCardId) {
		this.reinforceCardId = reinforceCardId;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getChangeDate() {
		return this.changeDate;
	}
	public void setChangeDate(org.joda.time.DateTime changeDate) {
		this.changeDate = changeDate;
	}
	
	@JsonProperty
	public Integer getLastQuality() {
		return this.lastQuality;
	}
	public void setLastQuality(Integer lastQuality) {
		this.lastQuality = lastQuality;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	public void setGiven(String given) {
		this.given = given;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	public void setWanted(String wanted) {
		this.wanted = wanted;
	}
	
	@JsonProperty
	public String getImage() {
		return this.image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	

}

/*       S.D.G.       */
