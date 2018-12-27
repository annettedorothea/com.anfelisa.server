package com.anfelisa.user.data;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AvailableData extends AbstractData implements IAvailableData {
	
	private Boolean available = false;
	

	public AvailableData(
		@JsonProperty("available") Boolean available
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.available = available;
	}

	public AvailableData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public Boolean getAvailable() {
		return this.available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
}

/*       S.D.G.       */
