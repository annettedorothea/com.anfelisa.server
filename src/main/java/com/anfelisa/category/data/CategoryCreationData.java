package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryCreationData extends AbstractCategoryCreationData implements ICategoryCreationData {
	
	public CategoryCreationData(
		@JsonProperty("username") String username, 
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
		@JsonProperty("publicRootCategory") Boolean publicRootCategory, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			username,
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
			publicRootCategory,
			userId,
			uuid
		);
	}

	public CategoryCreationData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
