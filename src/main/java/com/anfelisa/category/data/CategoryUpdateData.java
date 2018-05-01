package com.anfelisa.category.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryUpdateData extends AbstractData implements ICategoryUpdateData {
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private String categoryName;
	
	@NotNull
	private Integer categoryIndex;
	

	public CategoryUpdateData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryIndex") Integer categoryIndex
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryIndex = categoryIndex;
	}

	public CategoryUpdateData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public CategoryUpdateData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public CategoryUpdateData withCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}
	
	@JsonProperty
	public Integer getCategoryIndex() {
		return this.categoryIndex;
	}
	public void setCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
	}
	public CategoryUpdateData withCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new CategoryUpdatePresentationalData(
			this.categoryId,
			this.categoryName,
			this.categoryIndex
		);
	}

}

/*       S.D.G.       */
