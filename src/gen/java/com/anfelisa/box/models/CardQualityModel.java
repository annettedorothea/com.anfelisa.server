package com.anfelisa.box.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class CardQualityModel implements ICardQualityModel {

	@NotNull
	private Integer submittedQuality;
	

	public CardQualityModel(
		@JsonProperty("submittedQuality") Integer submittedQuality
	) {
		this.submittedQuality = submittedQuality;
	}

	@JsonProperty
	public Integer getSubmittedQuality() {
		return this.submittedQuality;
	}
	public void setSubmittedQuality(Integer submittedQuality) {
		this.submittedQuality = submittedQuality;
	}
	

}

/*       S.D.G.       */
