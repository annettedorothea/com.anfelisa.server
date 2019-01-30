package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryUpdateModel;

@JsonDeserialize(as=CategoryUpdateData.class)
public interface ICategoryUpdateData extends ICategoryUpdateModel, IDataContainer {
	
	ICategoryUpdateData withCategoryId(String categoryId);
	
	ICategoryUpdateData withCategoryName(String categoryName);
	
	ICategoryUpdateData withDictionaryLookup(Boolean dictionaryLookup);
	
	ICategoryUpdateData withGivenLanguage(String givenLanguage);
	
	ICategoryUpdateData withWantedLanguage(String wantedLanguage);
	
	ICategoryUpdateData withUserId(String userId);
	
	
}

/*       S.D.G.       */
