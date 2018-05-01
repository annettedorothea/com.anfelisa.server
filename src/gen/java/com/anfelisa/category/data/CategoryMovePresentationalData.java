package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryMoveModel;

@SuppressWarnings("all")
public class CategoryMovePresentationalData implements ICategoryMovePresentationalData {
	
	@NotNull
	private String categoryId;
	
	private String parentCategoryId;
	
	
	public CategoryMovePresentationalData(
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
	public CategoryMovePresentationalData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getParentCategoryId() {
		return this.parentCategoryId;
	}
	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	public CategoryMovePresentationalData withParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
		return this;
	}
	
}

/*       S.D.G.       */
