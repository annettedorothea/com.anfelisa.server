package com.anfelisa.box.data;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduledCardIdData extends AbstractData implements IScheduledCardIdData {
	
	private String scheduledCardId;
	

	public ScheduledCardIdData(
		@JsonProperty("scheduledCardId") String scheduledCardId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.scheduledCardId = scheduledCardId;
	}

	public ScheduledCardIdData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	public ScheduledCardIdData withScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new ScheduledCardIdPresentationalData(
			this.scheduledCardId
		);
	}

}

/*       S.D.G.       */
