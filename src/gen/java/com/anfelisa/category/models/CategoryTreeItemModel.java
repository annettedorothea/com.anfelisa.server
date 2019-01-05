package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CategoryTreeItemModel implements ICategoryTreeItemModel {

	private String categoryId;
	
	private String categoryName;
	
	private Integer categoryIndex;
	
	private Boolean empty = false;
	
	private Boolean editable = false;
	
	private Boolean hasBox = false;
	
	private String parentCategoryId;
	
	private Boolean dictionaryLookup = false;
	
	private String givenLanguage;
	
	private String wantedLanguage;
	
	private String rootCategoryId;
	
	private java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories;
	

	public CategoryTreeItemModel(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryIndex") Integer categoryIndex,
		@JsonProperty("empty") Boolean empty,
		@JsonProperty("editable") Boolean editable,
		@JsonProperty("hasBox") Boolean hasBox,
		@JsonProperty("parentCategoryId") String parentCategoryId,
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup,
		@JsonProperty("givenLanguage") String givenLanguage,
		@JsonProperty("wantedLanguage") String wantedLanguage,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("childCategories") java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories
	) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryIndex = categoryIndex;
		this.empty = empty;
		this.editable = editable;
		this.hasBox = hasBox;
		this.parentCategoryId = parentCategoryId;
		this.dictionaryLookup = dictionaryLookup;
		this.givenLanguage = givenLanguage;
		this.wantedLanguage = wantedLanguage;
		this.rootCategoryId = rootCategoryId;
		this.childCategories = childCategories;
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
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	
	@JsonProperty
	public Boolean getHasBox() {
		return this.hasBox;
	}
	public void setHasBox(Boolean hasBox) {
		this.hasBox = hasBox;
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
	

}

/*       S.D.G.       */
