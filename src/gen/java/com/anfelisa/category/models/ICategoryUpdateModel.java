package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryUpdateModel.class)
public interface ICategoryUpdateModel {

	String getCategoryId();
	String getCategoryName();
	Integer getCategoryIndex();
	Boolean getDictionaryLookup();
	String getGivenLanguage();
	String getWantedLanguage();

}

/*       S.D.G.       */
