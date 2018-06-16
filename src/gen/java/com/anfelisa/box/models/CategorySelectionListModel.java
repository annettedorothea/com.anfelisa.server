package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class CategorySelectionListModel implements ICategorySelectionListModel {

	private java.util.List<com.anfelisa.box.models.ICategorySelectionItemModel> categoryList;
	

	public CategorySelectionListModel(
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
	

}

/*       S.D.G.       */
