package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryUpdateModel.class)
public interface ICategoryUpdateModel {

	String getCategoryId();
	String getCategoryName();
	Boolean getDictionaryLookup();
	String getGivenLanguage();
	String getWantedLanguage();
	String getUserId();

}

/*       S.D.G.       */
