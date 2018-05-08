package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryListModel.class)
public interface ICategoryListModel {

	String getParentCategoryId();
	String getGrandParentCategoryId();
	String getParentCategoryName();
	java.util.List<com.anfelisa.category.models.ICategoryModel> getCategoryList();
	java.util.List<com.anfelisa.card.models.ICardModel> getCardList();

}

/*       S.D.G.       */
