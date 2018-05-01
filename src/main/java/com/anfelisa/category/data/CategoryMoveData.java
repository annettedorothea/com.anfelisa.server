package com.anfelisa.category.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryMoveData extends AbstractData implements ICategoryMoveData {
	
	@NotNull
	private String categoryId;
	
	private String parentCategoryId;
	

	public CategoryMoveData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("parentCategoryId") String parentCategoryId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryId = categoryId;
		this.parentCategoryId = parentCategoryId;
	}

	public CategoryMoveData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public CategoryMoveData withCategoryId(String categoryId) {
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
	public CategoryMoveData withParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new CategoryMovePresentationalData(
			this.categoryId,
			this.parentCategoryId
		);
	}

}

/*       S.D.G.       */
