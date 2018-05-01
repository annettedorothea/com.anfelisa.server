package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CategoryMoveModel implements ICategoryMoveModel {

	@NotNull
	private String categoryId;
	
	private String parentCategoryId;
	

	public CategoryMoveModel(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("parentCategoryId") String parentCategoryId
	) {
		this.categoryId = categoryId;
		this.parentCategoryId = parentCategoryId;
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getParentCategoryId() {
		return this.parentCategoryId;
	}
	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	

}

/*       S.D.G.       */
