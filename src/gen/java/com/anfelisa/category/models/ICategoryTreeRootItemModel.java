package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryTreeRootItemModel.class)
public interface ICategoryTreeRootItemModel {

	String getCategoryId();
	void setCategoryId(String categoryId);
	
	String getCategoryName();
	void setCategoryName(String categoryName);
	
	Integer getCategoryIndex();
	void setCategoryIndex(Integer categoryIndex);
	
	Boolean getEmpty();
	void setEmpty(Boolean empty);
	
	Boolean getEditable();
	void setEditable(Boolean editable);
	
	Boolean getHasBox();
	void setHasBox(Boolean hasBox);
	
	Boolean getDictionaryLookup();
	void setDictionaryLookup(Boolean dictionaryLookup);
	
	String getGivenLanguage();
	void setGivenLanguage(String givenLanguage);
	
	String getWantedLanguage();
	void setWantedLanguage(String wantedLanguage);
	
	java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> getChildCategories();
	void setChildCategories(java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories);
	

}

/*       S.D.G.       */
