package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryTreeItemModel;

@JsonDeserialize(as=CategoryTreeItemData.class)
public interface ICategoryTreeItemData extends ICategoryTreeItemModel, IDataContainer {
	
	ICategoryTreeItemData withCategoryId(String categoryId);
	
	ICategoryTreeItemData withCategoryName(String categoryName);
	
	ICategoryTreeItemData withCategoryIndex(Integer categoryIndex);
	
	ICategoryTreeItemData withEmpty(Boolean empty);
	
	ICategoryTreeItemData withEditable(Boolean editable);
	
	ICategoryTreeItemData withHasBox(Boolean hasBox);
	
	ICategoryTreeItemData withParentCategoryId(String parentCategoryId);
	
	ICategoryTreeItemData withDictionaryLookup(Boolean dictionaryLookup);
	
	ICategoryTreeItemData withGivenLanguage(String givenLanguage);
	
	ICategoryTreeItemData withWantedLanguage(String wantedLanguage);
	
	ICategoryTreeItemData withRootCategoryId(String rootCategoryId);
	
	ICategoryTreeItemData withChildCategories(java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories);
	
	
}

/*       S.D.G.       */
