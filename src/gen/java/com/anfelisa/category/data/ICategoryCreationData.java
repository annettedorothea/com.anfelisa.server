package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryCreationModel;

@JsonDeserialize(as=CategoryCreationData.class)
public interface ICategoryCreationData extends ICategoryCreationModel, IDataContainer {
	void mapFrom(com.anfelisa.category.models.ICategoryModel model);
	void mapFrom(com.anfelisa.category.models.IUserAccessToCategoryModel model);
	
	ICategoryCreationData withUsername(String username);
	
	ICategoryCreationData withCategoryId(String categoryId);
	
	ICategoryCreationData withCategoryName(String categoryName);
	
	ICategoryCreationData withCategoryAuthor(String categoryAuthor);
	
	ICategoryCreationData withCategoryIndex(Integer categoryIndex);
	
	ICategoryCreationData withParentCategoryId(String parentCategoryId);
	
	ICategoryCreationData withRootCategoryId(String rootCategoryId);
	
	ICategoryCreationData withDictionaryLookup(Boolean dictionaryLookup);
	
	ICategoryCreationData withGivenLanguage(String givenLanguage);
	
	ICategoryCreationData withWantedLanguage(String wantedLanguage);
	
	ICategoryCreationData withPublicRootCategory(Boolean publicRootCategory);
	
	ICategoryCreationData withUserId(String userId);
	
	
}

/*       S.D.G.       */
