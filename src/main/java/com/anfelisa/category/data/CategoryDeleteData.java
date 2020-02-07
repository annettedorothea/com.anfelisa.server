package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryDeleteData extends AbstractCategoryDeleteData implements ICategoryDeleteData {

	public CategoryDeleteData(
			@JsonProperty("categoryId") String categoryId,
			@JsonProperty("categoryIndex") Integer categoryIndex,
			@JsonProperty("parentCategoryId") String parentCategoryId,
			@JsonProperty("userId") String userId,
			@JsonProperty("uuid") String uuid) {
		super(
				categoryId,
				categoryIndex,
				parentCategoryId,
				userId,
				uuid);
	}

	public CategoryDeleteData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}

/* S.D.G. */
