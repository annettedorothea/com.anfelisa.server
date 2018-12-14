package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryTreeModel;
import com.anfelisa.user.models.IUserIdModel;

@SuppressWarnings("all")
public class CategoryTreePresentationalData implements ICategoryTreePresentationalData {
	
	private java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> categoryList;
	
	@NotNull
	private String userId;
	
	
	public CategoryTreePresentationalData(
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
	public CategoryTreePresentationalData withCategoryList(java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> categoryList) {
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
	public CategoryTreePresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
}

/*       S.D.G.       */
