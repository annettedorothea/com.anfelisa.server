package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryListModel.class)
public interface ICategoryListModel {

	String getParentCategoryId();
	String getGrandParentCategoryId();
	String getParentCategoryName();
	Boolean getParentDictionaryLookup();
	String getParentGivenLanguage();
	String getParentWantedLanguage();
	java.util.List<com.anfelisa.category.models.ICategoryModel> getCategoryList();
	java.util.List<com.anfelisa.card.models.ICardModel> getCardList();

}

/*       S.D.G.       */
