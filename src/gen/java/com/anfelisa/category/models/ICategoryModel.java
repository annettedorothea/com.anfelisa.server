package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryModel.class)
public interface ICategoryModel {

	String getCategoryId();
	String getCategoryName();
	String getCategoryAuthor();
	Integer getCategoryIndex();
	String getParentCategoryId();
	String getRootCategoryId();
	Boolean getDictionaryLookup();
	String getGivenLanguage();
	String getWantedLanguage();
	String getPath();

}

/*       S.D.G.       */
