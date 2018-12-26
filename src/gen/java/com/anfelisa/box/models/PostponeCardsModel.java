package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class PostponeCardsModel implements IPostponeCardsModel {

	@NotNull
	private Integer days;
	

	public PostponeCardsModel(
		@JsonProperty("days") Integer days
	) {
		this.days = days;
	}

	@JsonProperty
	public Integer getDays() {
		return this.days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	

}

/*       S.D.G.       */
