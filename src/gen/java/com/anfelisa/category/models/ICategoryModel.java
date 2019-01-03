package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
	
	String getPath();
	void setPath(String path);
	
	Boolean getPublicRootCategory();
	void setPublicRootCategory(Boolean publicRootCategory);
	

}

/*       S.D.G.       */
