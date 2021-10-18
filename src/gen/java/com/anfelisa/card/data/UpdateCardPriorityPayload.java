/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class UpdateCardPriorityPayload implements IUpdateCardPriorityPayload {
	
	private String cardId;
	
	private Integer priority;
	
	public UpdateCardPriorityPayload() {
	}
	
	public UpdateCardPriorityPayload(com.anfelisa.card.models.ICardUpdatePriorityModel data) {
		cardId = data.getCardId();
		priority = data.getPriority();
	}
	
	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	
	@JsonProperty
	public Integer getPriority() {
		return this.priority;
	}
	
}



/******* S.D.G. *******/



