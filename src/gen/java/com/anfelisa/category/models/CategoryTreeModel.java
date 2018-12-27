package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CategoryTreeModel implements ICategoryTreeModel {

	private java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> categoryList;
	
	private String userId;
	

	public CategoryTreeModel(
		@JsonProperty("categoryList") java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> categoryList,
		@JsonProperty("userId") String userId
	) {
		this.categoryList = categoryList;
		this.userId = userId;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> getCategoryList() {
		return this.categoryList;
	}
	public void setCategoryList(java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> categoryList) {
		this.categoryList = categoryList;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}

/*       S.D.G.       */
