package com.anfelisa.category.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class CategoryDeleteModel implements ICategoryDeleteModel {

	@NotNull
	private String categoryId;
	

	public CategoryDeleteModel(
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
	

}

/*       S.D.G.       */
