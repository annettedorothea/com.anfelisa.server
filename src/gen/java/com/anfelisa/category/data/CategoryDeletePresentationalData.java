package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryDeleteModel;
import com.anfelisa.user.models.IUserIdModel;

@SuppressWarnings("all")
public class CategoryDeletePresentationalData implements ICategoryDeletePresentationalData {
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private Integer categoryIndex;
	
	@NotNull
	private String parentCategoryId;
	
	@NotNull
	private String userId;
	
	
	public CategoryDeletePresentationalData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryIndex") Integer categoryIndex,
		@JsonProperty("parentCategoryId") String parentCategoryId,
		@JsonProperty("userId") String userId
	) {
		this.categoryId = categoryId;
		this.categoryIndex = categoryIndex;
		this.parentCategoryId = parentCategoryId;
		this.userId = userId;
		
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public CategoryDeletePresentationalData withCategoryId(String categoryId) {
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
	public CategoryDeletePresentationalData withCategoryIndex(Integer categoryIndex) {
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
	public CategoryDeletePresentationalData withParentCategoryId(String parentCategoryId) {
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
	public CategoryDeletePresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
}

/*       S.D.G.       */
