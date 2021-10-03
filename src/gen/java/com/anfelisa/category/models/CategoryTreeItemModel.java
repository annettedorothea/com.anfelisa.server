/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class CategoryTreeItemModel implements ICategoryTreeItemModel {

	private String categoryId;

	private String categoryName;

	private Integer categoryIndex;

	private Boolean empty = false;

	private String parentCategoryId;

	private Boolean dictionaryLookup = false;

	private String givenLanguage;

	private String wantedLanguage;

	private String rootCategoryId;

	private java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories;

	private Integer nonScheduledCount;

	private Boolean editable = false;


	public CategoryTreeItemModel() {
	}

	public CategoryTreeItemModel(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryIndex") Integer categoryIndex,
		@JsonProperty("empty") Boolean empty,
		@JsonProperty("parentCategoryId") String parentCategoryId,
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup,
		@JsonProperty("givenLanguage") String givenLanguage,
		@JsonProperty("wantedLanguage") String wantedLanguage,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("childCategories") java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories,
		@JsonProperty("nonScheduledCount") Integer nonScheduledCount,
		@JsonProperty("editable") Boolean editable
	) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryIndex = categoryIndex;
		this.empty = empty;
		this.parentCategoryId = parentCategoryId;
		this.dictionaryLookup = dictionaryLookup;
		this.givenLanguage = givenLanguage;
		this.wantedLanguage = wantedLanguage;
		this.rootCategoryId = rootCategoryId;
		this.childCategories = childCategories;
		this.nonScheduledCount = nonScheduledCount;
		this.editable = editable;
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
	public Integer getCategoryIndex() {
		return this.categoryIndex;
	}
	public void setCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
	}
	
	@JsonProperty
	public Boolean getEmpty() {
		return this.empty;
	}
	public void setEmpty(Boolean empty) {
		this.empty = empty;
	}
	
	@JsonProperty
	public String getParentCategoryId() {
		return this.parentCategoryId;
	}
	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
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
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> getChildCategories() {
		return this.childCategories;
	}
	public void setChildCategories(java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories) {
		this.childCategories = childCategories;
	}
	
	@JsonProperty
	public Integer getNonScheduledCount() {
		return this.nonScheduledCount;
	}
	public void setNonScheduledCount(Integer nonScheduledCount) {
		this.nonScheduledCount = nonScheduledCount;
	}
	
	@JsonProperty
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	

	public ICategoryTreeItemModel deepCopy() {
		ICategoryTreeItemModel copy = new CategoryTreeItemModel();
		copy.setCategoryId(this.getCategoryId());
		copy.setCategoryName(this.getCategoryName());
		copy.setCategoryIndex(this.getCategoryIndex());
		copy.setEmpty(this.getEmpty());
		copy.setParentCategoryId(this.getParentCategoryId());
		copy.setDictionaryLookup(this.getDictionaryLookup());
		copy.setGivenLanguage(this.getGivenLanguage());
		copy.setWantedLanguage(this.getWantedLanguage());
		copy.setRootCategoryId(this.getRootCategoryId());
		List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategoriesCopy = new ArrayList<com.anfelisa.category.models.ICategoryTreeItemModel>();
		for(com.anfelisa.category.models.ICategoryTreeItemModel item: this.getChildCategories()) {
			childCategoriesCopy.add(item.deepCopy());
		}
		copy.setChildCategories(childCategoriesCopy);
		copy.setNonScheduledCount(this.getNonScheduledCount());
		copy.setEditable(this.getEditable());
		return copy;
	}

}



/******* S.D.G. *******/



