package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryData extends AbstractCategoryData implements ICategoryData {

	public CategoryData(
			@JsonProperty("categoryId") String categoryId,
			@JsonProperty("categoryName") String categoryName,
			@JsonProperty("categoryAuthor") String categoryAuthor,
			@JsonProperty("categoryIndex") Integer categoryIndex,
			@JsonProperty("parentCategoryId") String parentCategoryId,
			@JsonProperty("rootCategoryId") String rootCategoryId,
			@JsonProperty("dictionaryLookup") Boolean dictionaryLookup,
			@JsonProperty("givenLanguage") String givenLanguage,
			@JsonProperty("wantedLanguage") String wantedLanguage,
			@JsonProperty("uuid") String uuid) {
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
				uuid);
	}

	public CategoryData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}

/* S.D.G. */
