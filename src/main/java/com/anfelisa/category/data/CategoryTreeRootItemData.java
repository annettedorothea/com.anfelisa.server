package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryTreeRootItemData extends AbstractCategoryTreeRootItemData implements ICategoryTreeRootItemData {

	public CategoryTreeRootItemData(
			@JsonProperty("categoryId") String categoryId,
			@JsonProperty("categoryName") String categoryName,
			@JsonProperty("categoryIndex") Integer categoryIndex,
			@JsonProperty("empty") Boolean empty,
			@JsonProperty("editable") Boolean editable,
			@JsonProperty("hasBox") Boolean hasBox,
			@JsonProperty("dictionaryLookup") Boolean dictionaryLookup,
			@JsonProperty("givenLanguage") String givenLanguage,
			@JsonProperty("wantedLanguage") String wantedLanguage,
			@JsonProperty("rootCategoryId") String rootCategoryId,
			@JsonProperty("childCategories") java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories,
			@JsonProperty("uuid") String uuid) {
		super(
				categoryId,
				categoryName,
				categoryIndex,
				empty,
				editable,
				hasBox,
				dictionaryLookup,
				givenLanguage,
				wantedLanguage,
				rootCategoryId,
				childCategories,
				uuid);
	}

	public CategoryTreeRootItemData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}

/* S.D.G. */
