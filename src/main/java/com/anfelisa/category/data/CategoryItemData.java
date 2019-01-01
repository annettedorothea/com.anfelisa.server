package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryItemData extends AbstractCategoryItemData implements ICategoryItemData {
	
	public CategoryItemData(
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("categoryName") String categoryName, 
		@JsonProperty("categoryAuthor") String categoryAuthor, 
		@JsonProperty("categoryIndex") Integer categoryIndex, 
		@JsonProperty("parentCategoryId") String parentCategoryId, 
		@JsonProperty("rootCategoryId") String rootCategoryId, 
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup, 
		@JsonProperty("givenLanguage") String givenLanguage, 
		@JsonProperty("wantedLanguage") String wantedLanguage, 
		@JsonProperty("path") String path, 
		@JsonProperty("empty") Boolean empty, 
		@JsonProperty("editable") Boolean editable, 
		@JsonProperty("hasBox") Boolean hasBox, 
		@JsonProperty("isRoot") Boolean isRoot, 
		@JsonProperty("publicRootCategory") Boolean publicRootCategory, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			categoryId,
			categoryName,
			categoryAuthor,
			categoryIndex,
			parentCategoryId,
			rootCategoryId,
			dictionaryLookup,
			givenLanguage,
			wantedLanguage,
			path,
			empty,
			editable,
			hasBox,
			isRoot,
			publicRootCategory,
			uuid
		);
	}

	public CategoryItemData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */