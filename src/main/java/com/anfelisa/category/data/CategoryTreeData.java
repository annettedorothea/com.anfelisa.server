package com.anfelisa.category.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryTreeData extends AbstractData implements ICategoryTreeData {
	
	private java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> categoryList;
	
	@NotNull
	private String userId;
	

	public CategoryTreeData(
		@JsonProperty("categoryList") java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> categoryList,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryList = categoryList;
		this.userId = userId;
	}

	public CategoryTreeData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> getCategoryList() {
		return this.categoryList;
	}
	public void setCategoryList(java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> categoryList) {
		this.categoryList = categoryList;
	}
	public CategoryTreeData withCategoryList(java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> categoryList) {
		this.categoryList = categoryList;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public CategoryTreeData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new CategoryTreePresentationalData(
			this.categoryList,
			this.userId
		);
	}

}

/*       S.D.G.       */
