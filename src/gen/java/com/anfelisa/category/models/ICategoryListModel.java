package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryListModel.class)
public interface ICategoryListModel {

	String getParentCategoryId();
	String getParentCategoryName();
	java.util.List<com.anfelisa.category.models.ICategoryModel> getCategoryList();

}

/*       S.D.G.       */
