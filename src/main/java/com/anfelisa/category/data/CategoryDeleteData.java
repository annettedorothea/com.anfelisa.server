package com.anfelisa.category.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryDeleteData extends AbstractData implements ICategoryDeleteData {
	
	@NotNull
	private String categoryId;
	

	public CategoryDeleteData(
		@JsonProperty("categoryId") String categoryId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryId = categoryId;
	}

	public CategoryDeleteData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public CategoryDeleteData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new CategoryDeletePresentationalData(
			this.categoryId
		);
	}

}

/*       S.D.G.       */
