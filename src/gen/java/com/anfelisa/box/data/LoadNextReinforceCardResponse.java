package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("all")
public class LoadNextReinforceCardResponse implements ILoadNextReinforceCardResponse {
	
	private String categoryId;
	
	@NotNull
	private String boxId;
	
	@NotNull
	private org.joda.time.DateTime changeDate;
	
	private String given;
	
	private String image;
	
	private Integer lastQuality;
	
	@NotNull
	private String reinforceCardId;
	
	private String wanted;
	
	public LoadNextReinforceCardResponse(com.anfelisa.box.models.INextReinforceCardModel data) {
		categoryId = data.getCategoryId();
		boxId = data.getBoxId();
		changeDate = data.getChangeDate();
		given = data.getGiven();
		image = data.getImage();
		lastQuality = data.getLastQuality();
		reinforceCardId = data.getReinforceCardId();
		wanted = data.getWanted();
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getChangeDate() {
		return this.changeDate;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	
	@JsonProperty
	public String getImage() {
		return this.image;
	}
	
	@JsonProperty
	public Integer getLastQuality() {
		return this.lastQuality;
	}
	
	@JsonProperty
	public String getReinforceCardId() {
		return this.reinforceCardId;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	
}

/*       S.D.G.       */
