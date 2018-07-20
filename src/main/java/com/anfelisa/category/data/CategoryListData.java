package com.anfelisa.category.data;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryListData extends AbstractData implements ICategoryListData {
	
	private String parentCategoryId;
	
	private String grandParentCategoryId;
	
	private String parentCategoryName;
	
	private Boolean parentDictionaryLookup = false;
	
	private Boolean rootDictionaryLookup = false;
	
	private String parentGivenLanguage;
	
	private String parentWantedLanguage;
	
	private java.util.List<com.anfelisa.category.models.ICategoryItemModel> categoryList;
	
	private java.util.List<com.anfelisa.card.models.ICardModel> cardList;
	
	private Boolean hasBox = false;
	
	private String userId;
	
	private Boolean parentEditable = false;
	
	private java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList;
	

	public CategoryListData(
		@JsonProperty("parentCategoryId") String parentCategoryId,
		@JsonProperty("grandParentCategoryId") String grandParentCategoryId,
		@JsonProperty("parentCategoryName") String parentCategoryName,
		@JsonProperty("parentDictionaryLookup") Boolean parentDictionaryLookup,
		@JsonProperty("rootDictionaryLookup") Boolean rootDictionaryLookup,
		@JsonProperty("parentGivenLanguage") String parentGivenLanguage,
		@JsonProperty("parentWantedLanguage") String parentWantedLanguage,
		@JsonProperty("categoryList") java.util.List<com.anfelisa.category.models.ICategoryItemModel> categoryList,
		@JsonProperty("cardList") java.util.List<com.anfelisa.card.models.ICardModel> cardList,
		@JsonProperty("hasBox") Boolean hasBox,
		@JsonProperty("userId") String userId,
		@JsonProperty("parentEditable") Boolean parentEditable,
		@JsonProperty("userList") java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.parentCategoryId = parentCategoryId;
		this.grandParentCategoryId = grandParentCategoryId;
		this.parentCategoryName = parentCategoryName;
		this.parentDictionaryLookup = parentDictionaryLookup;
		this.rootDictionaryLookup = rootDictionaryLookup;
		this.parentGivenLanguage = parentGivenLanguage;
		this.parentWantedLanguage = parentWantedLanguage;
		this.categoryList = categoryList;
		this.cardList = cardList;
		this.hasBox = hasBox;
		this.userId = userId;
		this.parentEditable = parentEditable;
		this.userList = userList;
	}

	public CategoryListData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getParentCategoryId() {
		return this.parentCategoryId;
	}
	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	public CategoryListData withParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
		return this;
	}
	
	@JsonProperty
	public String getGrandParentCategoryId() {
		return this.grandParentCategoryId;
	}
	public void setGrandParentCategoryId(String grandParentCategoryId) {
		this.grandParentCategoryId = grandParentCategoryId;
	}
	public CategoryListData withGrandParentCategoryId(String grandParentCategoryId) {
		this.grandParentCategoryId = grandParentCategoryId;
		return this;
	}
	
	@JsonProperty
	public String getParentCategoryName() {
		return this.parentCategoryName;
	}
	public void setParentCategoryName(String parentCategoryName) {
		this.parentCategoryName = parentCategoryName;
	}
	public CategoryListData withParentCategoryName(String parentCategoryName) {
		this.parentCategoryName = parentCategoryName;
		return this;
	}
	
	@JsonProperty
	public Boolean getParentDictionaryLookup() {
		return this.parentDictionaryLookup;
	}
	public void setParentDictionaryLookup(Boolean parentDictionaryLookup) {
		this.parentDictionaryLookup = parentDictionaryLookup;
	}
	public CategoryListData withParentDictionaryLookup(Boolean parentDictionaryLookup) {
		this.parentDictionaryLookup = parentDictionaryLookup;
		return this;
	}
	
	@JsonProperty
	public Boolean getRootDictionaryLookup() {
		return this.rootDictionaryLookup;
	}
	public void setRootDictionaryLookup(Boolean rootDictionaryLookup) {
		this.rootDictionaryLookup = rootDictionaryLookup;
	}
	public CategoryListData withRootDictionaryLookup(Boolean rootDictionaryLookup) {
		this.rootDictionaryLookup = rootDictionaryLookup;
		return this;
	}
	
	@JsonProperty
	public String getParentGivenLanguage() {
		return this.parentGivenLanguage;
	}
	public void setParentGivenLanguage(String parentGivenLanguage) {
		this.parentGivenLanguage = parentGivenLanguage;
	}
	public CategoryListData withParentGivenLanguage(String parentGivenLanguage) {
		this.parentGivenLanguage = parentGivenLanguage;
		return this;
	}
	
	@JsonProperty
	public String getParentWantedLanguage() {
		return this.parentWantedLanguage;
	}
	public void setParentWantedLanguage(String parentWantedLanguage) {
		this.parentWantedLanguage = parentWantedLanguage;
	}
	public CategoryListData withParentWantedLanguage(String parentWantedLanguage) {
		this.parentWantedLanguage = parentWantedLanguage;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.category.models.ICategoryItemModel> getCategoryList() {
		return this.categoryList;
	}
	public void setCategoryList(java.util.List<com.anfelisa.category.models.ICategoryItemModel> categoryList) {
		this.categoryList = categoryList;
	}
	public CategoryListData withCategoryList(java.util.List<com.anfelisa.category.models.ICategoryItemModel> categoryList) {
		this.categoryList = categoryList;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ICardModel> getCardList() {
		return this.cardList;
	}
	public void setCardList(java.util.List<com.anfelisa.card.models.ICardModel> cardList) {
		this.cardList = cardList;
	}
	public CategoryListData withCardList(java.util.List<com.anfelisa.card.models.ICardModel> cardList) {
		this.cardList = cardList;
		return this;
	}
	
	@JsonProperty
	public Boolean getHasBox() {
		return this.hasBox;
	}
	public void setHasBox(Boolean hasBox) {
		this.hasBox = hasBox;
	}
	public CategoryListData withHasBox(Boolean hasBox) {
		this.hasBox = hasBox;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public CategoryListData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public Boolean getParentEditable() {
		return this.parentEditable;
	}
	public void setParentEditable(Boolean parentEditable) {
		this.parentEditable = parentEditable;
	}
	public CategoryListData withParentEditable(Boolean parentEditable) {
		this.parentEditable = parentEditable;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.category.models.IUserWithAccessModel> getUserList() {
		return this.userList;
	}
	public void setUserList(java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList) {
		this.userList = userList;
	}
	public CategoryListData withUserList(java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList) {
		this.userList = userList;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new CategoryListPresentationalData(
			this.parentCategoryId,
			this.grandParentCategoryId,
			this.parentCategoryName,
			this.parentDictionaryLookup,
			this.rootDictionaryLookup,
			this.parentGivenLanguage,
			this.parentWantedLanguage,
			this.categoryList,
			this.cardList,
			this.hasBox,
			this.userId,
			this.parentEditable,
			this.userList
		);
	}

}

/*       S.D.G.       */
