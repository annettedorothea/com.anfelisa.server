package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

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
