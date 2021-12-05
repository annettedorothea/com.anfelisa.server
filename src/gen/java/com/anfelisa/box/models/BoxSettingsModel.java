/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class BoxSettingsModel implements IBoxSettingsModel {

	private String boxId;

	private Integer maxInterval;

	private Integer maxCardsPerDay;

	private String categoryName;

	private Boolean dictionaryLookup = false;

	private String givenLanguage;

	private String wantedLanguage;

	private String categoryId;

	private Integer allCards;

	private Integer allActiveCards;

	private Boolean shared = false;


	public BoxSettingsModel() {
	}

	public BoxSettingsModel(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("maxInterval") Integer maxInterval,
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup,
		@JsonProperty("givenLanguage") String givenLanguage,
		@JsonProperty("wantedLanguage") String wantedLanguage,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("allCards") Integer allCards,
		@JsonProperty("allActiveCards") Integer allActiveCards,
		@JsonProperty("shared") Boolean shared
	) {
		this.boxId = boxId;
		this.maxInterval = maxInterval;
		this.maxCardsPerDay = maxCardsPerDay;
		this.categoryName = categoryName;
		this.dictionaryLookup = dictionaryLookup;
		this.givenLanguage = givenLanguage;
		this.wantedLanguage = wantedLanguage;
		this.categoryId = categoryId;
		this.allCards = allCards;
		this.allActiveCards = allActiveCards;
		this.shared = shared;
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
	public Integer getMaxInterval() {
		return this.maxInterval;
	}
	public void setMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
	}
	
	@JsonProperty
	public Integer getMaxCardsPerDay() {
		return this.maxCardsPerDay;
	}
	public void setMaxCardsPerDay(Integer maxCardsPerDay) {
		this.maxCardsPerDay = maxCardsPerDay;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@JsonProperty
	public Boolean getDictionaryLookup() {
		return this.dictionaryLookup;
	}
	public void setDictionaryLookup(Boolean dictionaryLookup) {
		this.dictionaryLookup = dictionaryLookup;
	}
	
	@JsonProperty
	public String getGivenLanguage() {
		return this.givenLanguage;
	}
	public void setGivenLanguage(String givenLanguage) {
		this.givenLanguage = givenLanguage;
	}
	
	@JsonProperty
	public String getWantedLanguage() {
		return this.wantedLanguage;
	}
	public void setWantedLanguage(String wantedLanguage) {
		this.wantedLanguage = wantedLanguage;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public Integer getAllCards() {
		return this.allCards;
	}
	public void setAllCards(Integer allCards) {
		this.allCards = allCards;
	}
	
	@JsonProperty
	public Integer getAllActiveCards() {
		return this.allActiveCards;
	}
	public void setAllActiveCards(Integer allActiveCards) {
		this.allActiveCards = allActiveCards;
	}
	
	@JsonProperty
	public Boolean getShared() {
		return this.shared;
	}
	public void setShared(Boolean shared) {
		this.shared = shared;
	}
	

	public IBoxSettingsModel deepCopy() {
		IBoxSettingsModel copy = new BoxSettingsModel();
		copy.setBoxId(this.getBoxId());
		copy.setMaxInterval(this.getMaxInterval());
		copy.setMaxCardsPerDay(this.getMaxCardsPerDay());
		copy.setCategoryName(this.getCategoryName());
		copy.setDictionaryLookup(this.getDictionaryLookup());
		copy.setGivenLanguage(this.getGivenLanguage());
		copy.setWantedLanguage(this.getWantedLanguage());
		copy.setCategoryId(this.getCategoryId());
		copy.setAllCards(this.getAllCards());
		copy.setAllActiveCards(this.getAllActiveCards());
		copy.setShared(this.getShared());
		return copy;
	}

}



/******* S.D.G. *******/



