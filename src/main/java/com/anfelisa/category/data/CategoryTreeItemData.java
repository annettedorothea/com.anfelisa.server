package com.anfelisa.category.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryTreeItemData extends AbstractData implements ICategoryTreeItemData {
	
	private String categoryId;
	
	private String categoryName;
	
	private String categoryAuthor;
	
	private Integer categoryIndex;
	
	private String parentCategoryId;
	
	private String rootCategoryId;
	
	private Boolean dictionaryLookup = false;
	
	private String givenLanguage;
	
	private String wantedLanguage;
	
	@NotNull
	private String path;
	
	private Boolean empty = false;
	
	private Boolean editable = false;
	
	private Boolean hasBox = false;
	
	private Boolean isRoot = false;
	
	private Boolean publicRootCategory = false;
	
	@NotNull
	private String userId;
	

	public CategoryTreeItemData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryAuthor") String categoryAuthor,
		@JsonProperty("categoryIndex") Integer categoryIndex,
		@JsonProperty("parentCategoryId") String parentCategoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup,
		@JsonProperty("givenLanguage") String givenLanguage,
		@JsonProperty("wantedLanguage") String wantedLanguage,
		@JsonProperty("path") String path,
		@JsonProperty("empty") Boolean empty,
		@JsonProperty("editable") Boolean editable,
		@JsonProperty("hasBox") Boolean hasBox,
		@JsonProperty("isRoot") Boolean isRoot,
		@JsonProperty("publicRootCategory") Boolean publicRootCategory,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryAuthor = categoryAuthor;
		this.categoryIndex = categoryIndex;
		this.parentCategoryId = parentCategoryId;
		this.rootCategoryId = rootCategoryId;
		this.dictionaryLookup = dictionaryLookup;
		this.givenLanguage = givenLanguage;
		this.wantedLanguage = wantedLanguage;
		this.path = path;
		this.empty = empty;
		this.editable = editable;
		this.hasBox = hasBox;
		this.isRoot = isRoot;
		this.publicRootCategory = publicRootCategory;
		this.userId = userId;
	}

	public CategoryTreeItemData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public CategoryTreeItemData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public CategoryTreeItemData withCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}
	
	@JsonProperty
	public String getCategoryAuthor() {
		return this.categoryAuthor;
	}
	public void setCategoryAuthor(String categoryAuthor) {
		this.categoryAuthor = categoryAuthor;
	}
	public CategoryTreeItemData withCategoryAuthor(String categoryAuthor) {
		this.categoryAuthor = categoryAuthor;
		return this;
	}
	
	@JsonProperty
	public Integer getCategoryIndex() {
		return this.categoryIndex;
	}
	public void setCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
	}
	public CategoryTreeItemData withCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
		return this;
	}
	
	@JsonProperty
	public String getParentCategoryId() {
		return this.parentCategoryId;
	}
	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	public CategoryTreeItemData withParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
		return this;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	public CategoryTreeItemData withRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
		return this;
	}
	
	@JsonProperty
	public Boolean getDictionaryLookup() {
		return this.dictionaryLookup;
	}
	public void setDictionaryLookup(Boolean dictionaryLookup) {
		this.dictionaryLookup = dictionaryLookup;
	}
	public CategoryTreeItemData withDictionaryLookup(Boolean dictionaryLookup) {
		this.dictionaryLookup = dictionaryLookup;
		return this;
	}
	
	@JsonProperty
	public String getGivenLanguage() {
		return this.givenLanguage;
	}
	public void setGivenLanguage(String givenLanguage) {
		this.givenLanguage = givenLanguage;
	}
	public CategoryTreeItemData withGivenLanguage(String givenLanguage) {
		this.givenLanguage = givenLanguage;
		return this;
	}
	
	@JsonProperty
	public String getWantedLanguage() {
		return this.wantedLanguage;
	}
	public void setWantedLanguage(String wantedLanguage) {
		this.wantedLanguage = wantedLanguage;
	}
	public CategoryTreeItemData withWantedLanguage(String wantedLanguage) {
		this.wantedLanguage = wantedLanguage;
		return this;
	}
	
	@JsonProperty
	public String getPath() {
		return this.path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public CategoryTreeItemData withPath(String path) {
		this.path = path;
		return this;
	}
	
	@JsonProperty
	public Boolean getEmpty() {
		return this.empty;
	}
	public void setEmpty(Boolean empty) {
		this.empty = empty;
	}
	public CategoryTreeItemData withEmpty(Boolean empty) {
		this.empty = empty;
		return this;
	}
	
	@JsonProperty
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	public CategoryTreeItemData withEditable(Boolean editable) {
		this.editable = editable;
		return this;
	}
	
	@JsonProperty
	public Boolean getHasBox() {
		return this.hasBox;
	}
	public void setHasBox(Boolean hasBox) {
		this.hasBox = hasBox;
	}
	public CategoryTreeItemData withHasBox(Boolean hasBox) {
		this.hasBox = hasBox;
		return this;
	}
	
	@JsonProperty
	public Boolean getIsRoot() {
		return this.isRoot;
	}
	public void setIsRoot(Boolean isRoot) {
		this.isRoot = isRoot;
	}
	public CategoryTreeItemData withIsRoot(Boolean isRoot) {
		this.isRoot = isRoot;
		return this;
	}
	
	@JsonProperty
	public Boolean getPublicRootCategory() {
		return this.publicRootCategory;
	}
	public void setPublicRootCategory(Boolean publicRootCategory) {
		this.publicRootCategory = publicRootCategory;
	}
	public CategoryTreeItemData withPublicRootCategory(Boolean publicRootCategory) {
		this.publicRootCategory = publicRootCategory;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public CategoryTreeItemData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new CategoryTreeItemPresentationalData(
			this.categoryId,
			this.categoryName,
			this.categoryAuthor,
			this.categoryIndex,
			this.parentCategoryId,
			this.rootCategoryId,
			this.dictionaryLookup,
			this.givenLanguage,
			this.wantedLanguage,
			this.path,
			this.empty,
			this.editable,
			this.hasBox,
			this.isRoot,
			this.publicRootCategory,
			this.userId
		);
	}

}

/*       S.D.G.       */
