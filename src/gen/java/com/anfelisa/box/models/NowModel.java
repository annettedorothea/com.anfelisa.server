package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class NowModel implements INowModel {

	private org.joda.time.DateTime now;
	


	public NowModel(
		@JsonProperty("now") org.joda.time.DateTime now
	) {
		this.now = now;
	}

	@JsonProperty
	public org.joda.time.DateTime getNow() {
		return this.now;
	}
	public void setNow(org.joda.time.DateTime now) {
		this.now = now;
	}
	

		
}

/*       S.D.G.       */
