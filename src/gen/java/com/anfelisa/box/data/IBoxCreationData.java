/********************************************************************************
 * generated by de.acegen 1.0.2
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IBoxCreationModel;

@JsonDeserialize(as=BoxCreationData.class)
public interface IBoxCreationData extends IBoxCreationModel, IDataContainer {
	void mapFrom(com.anfelisa.category.models.ICategoryModel model);
	void mapFrom(com.anfelisa.category.models.IUserAccessToCategoryModel model);
	void mapFrom(com.anfelisa.box.models.IBoxModel model);
	
	IBoxCreationData withUsername(String username);
	
	IBoxCreationData withCategoryId(String categoryId);
	
	IBoxCreationData withCategoryName(String categoryName);
	
	IBoxCreationData withCategoryAuthor(String categoryAuthor);
	
	IBoxCreationData withCategoryIndex(Integer categoryIndex);
	
	IBoxCreationData withParentCategoryId(String parentCategoryId);
	
	IBoxCreationData withRootCategoryId(String rootCategoryId);
	
	IBoxCreationData withDictionaryLookup(Boolean dictionaryLookup);
	
	IBoxCreationData withGivenLanguage(String givenLanguage);
	
	IBoxCreationData withWantedLanguage(String wantedLanguage);
	
	IBoxCreationData withUserId(String userId);
	
	IBoxCreationData withEditable(Boolean editable);
	
	IBoxCreationData withBoxId(String boxId);
	
	IBoxCreationData withMaxInterval(Integer maxInterval);
	
	IBoxCreationData withMaxCardsPerDay(Integer maxCardsPerDay);
	
	
}



/******* S.D.G. *******/



