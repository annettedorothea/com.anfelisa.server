/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CategoryModel.class)
public interface ICategoryModel {

	String getCategoryId();
	void setCategoryId(String categoryId);
	
	String getCategoryName();
	void setCategoryName(String categoryName);
	
	String getCategoryAuthor();
	void setCategoryAuthor(String categoryAuthor);
	
	Integer getCategoryIndex();
	void setCategoryIndex(Integer categoryIndex);
	
	String getParentCategoryId();
	void setParentCategoryId(String parentCategoryId);
	
	String getRootCategoryId();
	void setRootCategoryId(String rootCategoryId);
	
	Boolean getDictionaryLookup();
	void setDictionaryLookup(Boolean dictionaryLookup);
	
	String getGivenLanguage();
	void setGivenLanguage(String givenLanguage);
	
	String getWantedLanguage();
	void setWantedLanguage(String wantedLanguage);
	
	
}




/******* S.D.G. *******/



