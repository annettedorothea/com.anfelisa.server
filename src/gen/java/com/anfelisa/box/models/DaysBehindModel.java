package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class DaysBehindModel implements IDaysBehindModel {

	private Integer daysBehind;
	

	public DaysBehindModel(
		@JsonProperty("daysBehind") Integer daysBehind
	) {
		this.daysBehind = daysBehind;
	}

	@JsonProperty
	public Integer getDaysBehind() {
		return this.daysBehind;
	}
	public void setDaysBehind(Integer daysBehind) {
		this.daysBehind = daysBehind;
	}
	

}

/*       S.D.G.       */
