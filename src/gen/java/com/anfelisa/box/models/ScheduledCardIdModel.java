package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ScheduledCardIdModel implements IScheduledCardIdModel {

	private Integer scheduledCardId;
	

	public ScheduledCardIdModel(
		@JsonProperty("scheduledCardId") Integer scheduledCardId
	) {
		this.scheduledCardId = scheduledCardId;
	}

	@JsonProperty
	public Integer getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(Integer scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	

}

/*       S.D.G.       */
