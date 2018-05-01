package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryListModel;

@SuppressWarnings("all")
public class CategoryListPresentationalData implements ICategoryListPresentationalData {
	
	private String parentCategoryId;
	
	private String parentCategoryName;
	
	private java.util.List<com.anfelisa.category.models.ICategoryModel> categoryList;
	
	
	public CategoryListPresentationalData(
		@JsonProperty("parentCategoryId") String parentCategoryId,
		@JsonProperty("parentCategoryName") String parentCategoryName,
		@JsonProperty("categoryList") java.util.List<com.anfelisa.category.models.ICategoryModel> categoryList
	) {
		this.parentCategoryId = parentCategoryId;
		this.parentCategoryName = parentCategoryName;
		this.categoryList = categoryList;
		
	}

	@JsonProperty
	public String getParentCategoryId() {
		return this.parentCategoryId;
	}
	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	public CategoryListPresentationalData withParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
		return this;
	}
	
	@JsonProperty
	public String getParentCategoryName() {
		return this.parentCategoryName;
	}
	public void setParentCategoryName(String parentCategoryName) {
		this.parentCategoryName = parentCategoryName;
	}
	public CategoryListPresentationalData withParentCategoryName(String parentCategoryName) {
		this.parentCategoryName = parentCategoryName;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.category.models.ICategoryModel> getCategoryList() {
		return this.categoryList;
	}
	public void setCategoryList(java.util.List<com.anfelisa.category.models.ICategoryModel> categoryList) {
		this.categoryList = categoryList;
	}
	public CategoryListPresentationalData withCategoryList(java.util.List<com.anfelisa.category.models.ICategoryModel> categoryList) {
		this.categoryList = categoryList;
		return this;
	}
	
}

/*       S.D.G.       */
