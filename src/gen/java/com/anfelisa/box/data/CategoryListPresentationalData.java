package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICategorySelectionListModel;
import com.anfelisa.user.models.IUserIdModel;

@SuppressWarnings("all")
public class CategoryListPresentationalData implements ICategoryListPresentationalData {
	
	private java.util.List<com.anfelisa.box.models.ICategorySelectionItemModel> categoryList;
	
	@NotNull
	private String userId;
	
	
	public CategoryListPresentationalData(
		@JsonProperty("categoryList") java.util.List<com.anfelisa.box.models.ICategorySelectionItemModel> categoryList,
		@JsonProperty("userId") String userId
	) {
		this.categoryList = categoryList;
		this.userId = userId;
		
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
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public CategoryListPresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
}

/*       S.D.G.       */
