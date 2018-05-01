package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class AvailableModel implements IAvailableModel {

	private Boolean available = false;
	

	public AvailableModel(
		@JsonProperty("available") Boolean available
	) {
		this.available = available;
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
