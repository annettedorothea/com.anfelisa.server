package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class ScheduledCardIdPresentationalData implements IScheduledCardIdPresentationalData {
	
	private String scheduledCardId;
	
	
	public ScheduledCardIdPresentationalData(
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
	public ScheduledCardIdPresentationalData withScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
		return this;
	}
	
}

/*       S.D.G.       */
