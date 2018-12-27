package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReinforceCardData extends AbstractData implements IReinforceCardData {
	
	@NotNull
	private String reinforceCardId;
	
	@NotNull
	private String scheduledCardId;
	
	@NotNull
	private String boxId;
	
	@NotNull
	private org.joda.time.DateTime changeDate;
	

	public ReinforceCardData(
		@JsonProperty("reinforceCardId") String reinforceCardId,
		@JsonProperty("scheduledCardId") String scheduledCardId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("changeDate") org.joda.time.DateTime changeDate
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.reinforceCardId = reinforceCardId;
		this.scheduledCardId = scheduledCardId;
		this.boxId = boxId;
		this.changeDate = changeDate;
	}

	public ReinforceCardData( String uuid ) {
		super(uuid);
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
