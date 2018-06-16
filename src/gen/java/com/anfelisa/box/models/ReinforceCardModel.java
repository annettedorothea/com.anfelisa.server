package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ReinforceCardModel implements IReinforceCardModel {

	@NotNull
	private String reinforceCardId;
	
	@NotNull
	private String scheduledCardId;
	
	@NotNull
	private String boxId;
	
	@NotNull
	private org.joda.time.DateTime changeDate;
	

	public ReinforceCardModel(
		@JsonProperty("reinforceCardId") String reinforceCardId,
		@JsonProperty("scheduledCardId") String scheduledCardId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("changeDate") org.joda.time.DateTime changeDate
	) {
		this.reinforceCardId = reinforceCardId;
		this.scheduledCardId = scheduledCardId;
		this.boxId = boxId;
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
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
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
