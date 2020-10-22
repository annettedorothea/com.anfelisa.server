/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.box.data;

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
public class CreateBoxPayload implements ICreateBoxPayload {
	
	private String categoryName;
	
	private Boolean dictionaryLookup = false;
	
	private String givenLanguage;
	
	private String wantedLanguage;
	
	private Integer maxCardsPerDay;
	
	private Integer maxInterval;
	
	public CreateBoxPayload() {
	}
	
	public CreateBoxPayload(com.anfelisa.box.models.IBoxCreationModel data) {
		categoryName = data.getCategoryName();
		dictionaryLookup = data.getDictionaryLookup();
		givenLanguage = data.getGivenLanguage();
		wantedLanguage = data.getWantedLanguage();
		maxCardsPerDay = data.getMaxCardsPerDay();
		maxInterval = data.getMaxInterval();
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	
	@JsonProperty
	public Boolean getDictionaryLookup() {
		return this.dictionaryLookup;
	}
	
	@JsonProperty
	public String getGivenLanguage() {
		return this.givenLanguage;
	}
	
	@JsonProperty
	public String getWantedLanguage() {
		return this.wantedLanguage;
	}
	
	@JsonProperty
	public Integer getMaxCardsPerDay() {
		return this.maxCardsPerDay;
	}
	
	@JsonProperty
	public Integer getMaxInterval() {
		return this.maxInterval;
	}
	
}



/******* S.D.G. *******/


