package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryUpdateModel;

@SuppressWarnings("all")
public class CategoryUpdatePresentationalData implements ICategoryUpdatePresentationalData {
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private String categoryName;
	
	@NotNull
	private Integer categoryIndex;
	
	
	public CategoryUpdatePresentationalData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryIndex") Integer categoryIndex
	) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryIndex = categoryIndex;
		
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public CategoryUpdatePresentationalData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public CategoryUpdatePresentationalData withCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}
	
	@JsonProperty
	public Integer getCategoryIndex() {
		return this.categoryIndex;
	}
	public void setCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
	}
	public CategoryUpdatePresentationalData withCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
		return this;
	}
	
}

/*       S.D.G.       */
