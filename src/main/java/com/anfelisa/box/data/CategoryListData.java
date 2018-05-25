package com.anfelisa.box.data;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryListData extends AbstractData implements ICategoryListData {
	
	private java.util.List<com.anfelisa.box.models.ICategorySelectionItemModel> categoryList;
	

	public CategoryListData(
		@JsonProperty("categoryList") java.util.List<com.anfelisa.box.models.ICategorySelectionItemModel> categoryList
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryList = categoryList;
	}

	public CategoryListData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public java.util.List<com.anfelisa.box.models.ICategorySelectionItemModel> getCategoryList() {
		return this.categoryList;
	}
	public void setCategoryList(java.util.List<com.anfelisa.box.models.ICategorySelectionItemModel> categoryList) {
		this.categoryList = categoryList;
	}
	public CategoryListData withCategoryList(java.util.List<com.anfelisa.box.models.ICategorySelectionItemModel> categoryList) {
		this.categoryList = categoryList;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new CategoryListPresentationalData(
			this.categoryList
		);
	}

}

/*       S.D.G.       */
