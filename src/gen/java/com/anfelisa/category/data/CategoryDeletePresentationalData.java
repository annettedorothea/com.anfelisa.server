package com.anfelisa.category.data;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class CategoryDeletePresentationalData implements ICategoryDeletePresentationalData {
	
	@NotNull
	private String categoryId;
	
	
	public CategoryDeletePresentationalData(
		@JsonProperty("categoryId") String categoryId
	) {
		this.categoryId = categoryId;
		
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public CategoryDeletePresentationalData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
}

/*       S.D.G.       */
