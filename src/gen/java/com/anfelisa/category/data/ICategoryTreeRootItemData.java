package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryTreeRootItemModel;

@JsonDeserialize(as=CategoryTreeRootItemData.class)
public interface ICategoryTreeRootItemData extends ICategoryTreeRootItemModel, IDataContainer {
	
	ICategoryTreeRootItemData withCategoryId(String categoryId);
	
	ICategoryTreeRootItemData withCategoryName(String categoryName);
	
	ICategoryTreeRootItemData withCategoryIndex(Integer categoryIndex);
	
	ICategoryTreeRootItemData withEmpty(Boolean empty);
	
	ICategoryTreeRootItemData withEditable(Boolean editable);
	
	ICategoryTreeRootItemData withHasBox(Boolean hasBox);
	
	ICategoryTreeRootItemData withDictionaryLookup(Boolean dictionaryLookup);
	
	ICategoryTreeRootItemData withGivenLanguage(String givenLanguage);
	
	ICategoryTreeRootItemData withWantedLanguage(String wantedLanguage);
	
	ICategoryTreeRootItemData withRootCategoryId(String rootCategoryId);
	
	ICategoryTreeRootItemData withChildCategories(java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories);
	
	
}

/*       S.D.G.       */
