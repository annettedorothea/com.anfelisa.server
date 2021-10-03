/********************************************************************************
 * generated by de.acegen 1.5.4
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
public class CreateCardPayload implements ICreateCardPayload {
	
	private String wanted;
	
	private String given;
	
	private String categoryId;
	
	public CreateCardPayload() {
	}
	
	public CreateCardPayload(com.anfelisa.card.models.ICardCreationModel data) {
		wanted = data.getWanted();
		given = data.getGiven();
		categoryId = data.getCategoryId();
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	
}



/******* S.D.G. *******/



