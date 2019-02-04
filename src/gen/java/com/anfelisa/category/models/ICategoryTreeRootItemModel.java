package com.anfelisa.category.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
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
	
	String getRootCategoryId();
	void setRootCategoryId(String rootCategoryId);
	
	java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> getChildCategories();
	void setChildCategories(java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories);
	
	
	List<String> equalsPrimitiveTypes(ICategoryTreeRootItemModel other);
	
}

/*       S.D.G.       */
