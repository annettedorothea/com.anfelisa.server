/********************************************************************************
 * generated by de.acegen 1.6.4
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
public class BoxCreationModel implements IBoxCreationModel {

	private String username;

	private String categoryId;

	private String categoryName;

	private String categoryAuthor;

	private Integer categoryIndex;

	private String parentCategoryId;

	private String rootCategoryId;

	private Boolean dictionaryLookup = false;

	private String givenLanguage;

	private String wantedLanguage;

	private String userId;

	private Boolean editable = false;

	private String boxId;

	private Integer maxInterval;

	private Integer maxCardsPerDay;

	private Boolean reverse = false;

	private Boolean archived = false;


	public BoxCreationModel() {
	}

	public BoxCreationModel(
		@JsonProperty("username") String username,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryAuthor") String categoryAuthor,
		@JsonProperty("categoryIndex") Integer categoryIndex,
		@JsonProperty("parentCategoryId") String parentCategoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup,
		@JsonProperty("givenLanguage") String givenLanguage,
		@JsonProperty("wantedLanguage") String wantedLanguage,
		@JsonProperty("userId") String userId,
		@JsonProperty("editable") Boolean editable,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("maxInterval") Integer maxInterval,
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay,
		@JsonProperty("reverse") Boolean reverse,
		@JsonProperty("archived") Boolean archived
	) {
		this.username = username;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryAuthor = categoryAuthor;
		this.categoryIndex = categoryIndex;
		this.parentCategoryId = parentCategoryId;
		this.rootCategoryId = rootCategoryId;
		this.dictionaryLookup = dictionaryLookup;
		this.givenLanguage = givenLanguage;
		this.wantedLanguage = wantedLanguage;
		this.userId = userId;
		this.editable = editable;
		this.boxId = boxId;
		this.maxInterval = maxInterval;
		this.maxCardsPerDay = maxCardsPerDay;
		this.reverse = reverse;
		this.archived = archived;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@JsonProperty
	public String getCategoryAuthor() {
		return this.categoryAuthor;
	}
	public void setCategoryAuthor(String categoryAuthor) {
		this.categoryAuthor = categoryAuthor;
	}
	
	@JsonProperty
	public Integer getCategoryIndex() {
		return this.categoryIndex;
	}
	public void setCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
	}
	
	@JsonProperty
	public String getParentCategoryId() {
		return this.parentCategoryId;
	}
	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
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
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
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
	public Boolean getReverse() {
		return this.reverse;
	}
	public void setReverse(Boolean reverse) {
		this.reverse = reverse;
	}
	
	@JsonProperty
	public Boolean getArchived() {
		return this.archived;
	}
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}
	

	public IBoxCreationModel deepCopy() {
		IBoxCreationModel copy = new BoxCreationModel();
		copy.setUsername(this.getUsername());
		copy.setCategoryId(this.getCategoryId());
		copy.setCategoryName(this.getCategoryName());
		copy.setCategoryAuthor(this.getCategoryAuthor());
		copy.setCategoryIndex(this.getCategoryIndex());
		copy.setParentCategoryId(this.getParentCategoryId());
		copy.setRootCategoryId(this.getRootCategoryId());
		copy.setDictionaryLookup(this.getDictionaryLookup());
		copy.setGivenLanguage(this.getGivenLanguage());
		copy.setWantedLanguage(this.getWantedLanguage());
		copy.setUserId(this.getUserId());
		copy.setEditable(this.getEditable());
		copy.setBoxId(this.getBoxId());
		copy.setMaxInterval(this.getMaxInterval());
		copy.setMaxCardsPerDay(this.getMaxCardsPerDay());
		copy.setReverse(this.getReverse());
		copy.setArchived(this.getArchived());
		return copy;
	}

}



/******* S.D.G. *******/



