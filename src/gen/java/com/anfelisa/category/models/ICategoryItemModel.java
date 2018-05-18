package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryItemModel.class)
public interface ICategoryItemModel {

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
	Boolean getEmpty();

}

/*       S.D.G.       */
