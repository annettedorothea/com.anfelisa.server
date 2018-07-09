package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryListModel.class)
public interface ICategoryListModel {

	String getParentCategoryId();
	String getGrandParentCategoryId();
	String getParentCategoryName();
	Boolean getParentDictionaryLookup();
	Boolean getRootDictionaryLookup();
	String getParentGivenLanguage();
	String getParentWantedLanguage();
	java.util.List<com.anfelisa.category.models.ICategoryItemModel> getCategoryList();
	java.util.List<com.anfelisa.card.models.ICardModel> getCardList();
	Boolean getHasBox();
	String getUserId();
	Boolean getParentEditable();

}

/*       S.D.G.       */
