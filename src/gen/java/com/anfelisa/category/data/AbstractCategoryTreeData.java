package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

@SuppressWarnings("unused")
public abstract class AbstractCategoryTreeData extends AbstractData implements ICategoryTreeData {
	
	private java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> categoryList;
	
	private String userId;
	

	public AbstractCategoryTreeData(
		@JsonProperty("categoryList") java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> categoryList,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryList = categoryList;
		this.userId = userId;
	}

	public AbstractCategoryTreeData( String uuid ) {
		super(uuid);
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
