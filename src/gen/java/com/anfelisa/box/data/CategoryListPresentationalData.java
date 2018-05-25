package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class CategoryListPresentationalData implements ICategoryListPresentationalData {
	
	private java.util.List<com.anfelisa.box.models.ICategorySelectionItemModel> categoryList;
	
	
	public CategoryListPresentationalData(
		@JsonProperty("categoryList") java.util.List<com.anfelisa.box.models.ICategorySelectionItemModel> categoryList
	) {
		this.categoryList = categoryList;
		
	}

	@JsonProperty
	public java.util.List<com.anfelisa.box.models.ICategorySelectionItemModel> getCategoryList() {
		return this.categoryList;
	}
	public void setCategoryList(java.util.List<com.anfelisa.box.models.ICategorySelectionItemModel> categoryList) {
		this.categoryList = categoryList;
	}
	public CategoryListPresentationalData withCategoryList(java.util.List<com.anfelisa.box.models.ICategorySelectionItemModel> categoryList) {
		this.categoryList = categoryList;
		return this;
	}
	
}

/*       S.D.G.       */
