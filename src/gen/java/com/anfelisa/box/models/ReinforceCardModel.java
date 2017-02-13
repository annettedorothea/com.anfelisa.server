package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ReinforceCardModel implements IReinforceCardModel {

	@NotNull
	private Integer scheduledCardId;
	
	@NotNull
	private org.joda.time.DateTime scheduledDate;
	
	private Integer lastQuality;
	
	@NotNull
	private org.joda.time.DateTime timestamp;
	

	private com.anfelisa.box.models.ICardContentModel cardContent;
	

	public ReinforceCardModel(
		@JsonProperty("scheduledCardId") Integer scheduledCardId,
		@JsonProperty("scheduledDate") org.joda.time.DateTime scheduledDate,
		@JsonProperty("lastQuality") Integer lastQuality,
		@JsonProperty("timestamp") org.joda.time.DateTime timestamp
	) {
		this.scheduledCardId = scheduledCardId;
		this.scheduledDate = scheduledDate;
		this.lastQuality = lastQuality;
		this.timestamp = timestamp;
	}

	@JsonProperty
	public Integer getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(Integer scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getScheduledDate() {
		return this.scheduledDate;
	}
	public void setScheduledDate(org.joda.time.DateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	
	@JsonProperty
	public Integer getLastQuality() {
		return this.lastQuality;
	}
	public void setLastQuality(Integer lastQuality) {
		this.lastQuality = lastQuality;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getTimestamp() {
		return this.timestamp;
	}
	public void setTimestamp(org.joda.time.DateTime timestamp) {
		this.timestamp = timestamp;
	}
	

	@JsonProperty
	public com.anfelisa.box.models.ICardContentModel getCardContent() {
		return this.cardContent;
	}
	public void setCardContent(com.anfelisa.box.models.ICardContentModel cardContent) {
		this.cardContent = cardContent;
	}
	
		
}

/*       S.D.G.       */
