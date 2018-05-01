package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class ScheduledCardIdModel implements IScheduledCardIdModel {

	private String scheduledCardId;
	

	public ScheduledCardIdModel(
		@JsonProperty("scheduledCardId") String scheduledCardId
	) {
		this.scheduledCardId = scheduledCardId;
	}

	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	

}

/*       S.D.G.       */
