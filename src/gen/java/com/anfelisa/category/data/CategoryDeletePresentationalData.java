package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryDeleteModel;

@SuppressWarnings("all")
public class CategoryDeletePresentationalData implements ICategoryDeletePresentationalData {
	
	@NotNull
	private String categoryId;
	
	
	public CategoryDeletePresentationalData(
		@JsonProperty("categoryId") String categoryId
	) {
		this.categoryId = categoryId;
		
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
	
}

/*       S.D.G.       */
