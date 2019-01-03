package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryItemModel.class)
public interface ICategoryItemModel {

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
	
	Boolean getEmpty();
	void setEmpty(Boolean empty);
	
	Boolean getEditable();
	void setEditable(Boolean editable);
	
	Boolean getHasBox();
	void setHasBox(Boolean hasBox);
	
	Boolean getIsRoot();
	void setIsRoot(Boolean isRoot);
	
	Boolean getPublicRootCategory();
	void setPublicRootCategory(Boolean publicRootCategory);
	

}

/*       S.D.G.       */
