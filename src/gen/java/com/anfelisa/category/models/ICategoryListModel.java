package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryListModel.class)
public interface ICategoryListModel {

	String getParentCategoryId();
	void setParentCategoryId(String parentCategoryId);
	
	String getGrandParentCategoryId();
	void setGrandParentCategoryId(String grandParentCategoryId);
	
	String getParentCategoryName();
	void setParentCategoryName(String parentCategoryName);
	
	Boolean getParentDictionaryLookup();
	void setParentDictionaryLookup(Boolean parentDictionaryLookup);
	
	Boolean getRootDictionaryLookup();
	void setRootDictionaryLookup(Boolean rootDictionaryLookup);
	
	String getParentGivenLanguage();
	void setParentGivenLanguage(String parentGivenLanguage);
	
	String getParentWantedLanguage();
	void setParentWantedLanguage(String parentWantedLanguage);
	
	java.util.List<com.anfelisa.category.models.ICategoryItemModel> getCategoryList();
	void setCategoryList(java.util.List<com.anfelisa.category.models.ICategoryItemModel> categoryList);
	
	java.util.List<com.anfelisa.card.models.ICardModel> getCardList();
	void setCardList(java.util.List<com.anfelisa.card.models.ICardModel> cardList);
	
	Boolean getHasBox();
	void setHasBox(Boolean hasBox);
	
	String getUserId();
	void setUserId(String userId);
	
	Boolean getParentEditable();
	void setParentEditable(Boolean parentEditable);
	
	java.util.List<com.anfelisa.category.models.IUserWithAccessModel> getUserList();
	void setUserList(java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList);
	

}

/*       S.D.G.       */
