/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public class UpdateBoxPayload {
	
	private Integer maxInterval;
	
	private Integer maxCardsPerDay;
	
	private String boxId;
	
	private String categoryId;
	
	private String categoryName;
	
	private Boolean dictionaryLookup;
	
	private String givenLanguage;
	
	private String wantedLanguage;
	
	public UpdateBoxPayload() {
	}
	
	
	@JsonProperty
	public Integer getMaxInterval() {
		return this.maxInterval;
	}
	
	@JsonProperty
	public Integer getMaxCardsPerDay() {
		return this.maxCardsPerDay;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
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
	
}



/******* S.D.G. *******/



