package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class TodayModel implements ITodayModel {

	@NotNull
	private org.joda.time.DateTime today;
	

	public TodayModel(
		@JsonProperty("today") org.joda.time.DateTime today
	) {
		this.today = today;
	}

	@JsonProperty
	public org.joda.time.DateTime getToday() {
		return this.today;
	}
	public void setToday(org.joda.time.DateTime today) {
		this.today = today;
	}
	

}

/*       S.D.G.       */
