package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CategoryListModel implements ICategoryListModel {

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
	

	public CategoryListModel(
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
	) {
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

	@JsonProperty
	public String getParentCategoryId() {
		return this.parentCategoryId;
	}
	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	
	@JsonProperty
	public String getGrandParentCategoryId() {
		return this.grandParentCategoryId;
	}
	public void setGrandParentCategoryId(String grandParentCategoryId) {
		this.grandParentCategoryId = grandParentCategoryId;
	}
	
	@JsonProperty
	public String getParentCategoryName() {
		return this.parentCategoryName;
	}
	public void setParentCategoryName(String parentCategoryName) {
		this.parentCategoryName = parentCategoryName;
	}
	
	@JsonProperty
	public Boolean getParentDictionaryLookup() {
		return this.parentDictionaryLookup;
	}
	public void setParentDictionaryLookup(Boolean parentDictionaryLookup) {
		this.parentDictionaryLookup = parentDictionaryLookup;
	}
	
	@JsonProperty
	public Boolean getRootDictionaryLookup() {
		return this.rootDictionaryLookup;
	}
	public void setRootDictionaryLookup(Boolean rootDictionaryLookup) {
		this.rootDictionaryLookup = rootDictionaryLookup;
	}
	
	@JsonProperty
	public String getParentGivenLanguage() {
		return this.parentGivenLanguage;
	}
	public void setParentGivenLanguage(String parentGivenLanguage) {
		this.parentGivenLanguage = parentGivenLanguage;
	}
	
	@JsonProperty
	public String getParentWantedLanguage() {
		return this.parentWantedLanguage;
	}
	public void setParentWantedLanguage(String parentWantedLanguage) {
		this.parentWantedLanguage = parentWantedLanguage;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.category.models.ICategoryItemModel> getCategoryList() {
		return this.categoryList;
	}
	public void setCategoryList(java.util.List<com.anfelisa.category.models.ICategoryItemModel> categoryList) {
		this.categoryList = categoryList;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ICardModel> getCardList() {
		return this.cardList;
	}
	public void setCardList(java.util.List<com.anfelisa.card.models.ICardModel> cardList) {
		this.cardList = cardList;
	}
	
	@JsonProperty
	public Boolean getHasBox() {
		return this.hasBox;
	}
	public void setHasBox(Boolean hasBox) {
		this.hasBox = hasBox;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public Boolean getParentEditable() {
		return this.parentEditable;
	}
	public void setParentEditable(Boolean parentEditable) {
		this.parentEditable = parentEditable;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.category.models.IUserWithAccessModel> getUserList() {
		return this.userList;
	}
	public void setUserList(java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList) {
		this.userList = userList;
	}
	

}

/*       S.D.G.       */
