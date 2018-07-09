package com.anfelisa.category.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryDeleteData extends AbstractData implements ICategoryDeleteData {
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private Integer categoryIndex;
	
	@NotNull
	private String parentCategoryId;
	
	@NotNull
	private String userId;
	

	public CategoryDeleteData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryIndex") Integer categoryIndex,
		@JsonProperty("parentCategoryId") String parentCategoryId,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryId = categoryId;
		this.categoryIndex = categoryIndex;
		this.parentCategoryId = parentCategoryId;
		this.userId = userId;
	}

	public CategoryDeleteData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public CategoryDeleteData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public Integer getCategoryIndex() {
		return this.categoryIndex;
	}
	public void setCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
	}
	public CategoryDeleteData withCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
		return this;
	}
	
	@JsonProperty
	public String getParentCategoryId() {
		return this.parentCategoryId;
	}
	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	public CategoryDeleteData withParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public CategoryDeleteData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new CategoryDeletePresentationalData(
			this.categoryId,
			this.categoryIndex,
			this.parentCategoryId,
			this.userId
		);
	}

}

/*       S.D.G.       */
