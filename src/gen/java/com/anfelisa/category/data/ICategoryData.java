/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.category.models.ICategoryModel;

@JsonDeserialize(as=CategoryData.class)
public interface ICategoryData extends ICategoryModel, IDataContainer {
	
	ICategoryData withCategoryId(String categoryId);
	
	ICategoryData withCategoryName(String categoryName);
	
	ICategoryData withCategoryAuthor(String categoryAuthor);
	
	ICategoryData withCategoryIndex(Integer categoryIndex);
	
	ICategoryData withParentCategoryId(String parentCategoryId);
	
	ICategoryData withRootCategoryId(String rootCategoryId);
	
	ICategoryData withDictionaryLookup(Boolean dictionaryLookup);
	
	ICategoryData withGivenLanguage(String givenLanguage);
	
	ICategoryData withWantedLanguage(String wantedLanguage);
	
	
	ICategoryData deepCopy();
}



/******* S.D.G. *******/



