package com.anfelisa.category.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryCreationData extends AbstractData implements ICategoryCreationData {
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private String categoryName;
	
	@NotNull
	private String categoryAuthor;
	
	@NotNull
	private Integer categoryIndex;
	
	private String parentCategoryId;
	

	public CategoryCreationData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryAuthor") String categoryAuthor,
		@JsonProperty("categoryIndex") Integer categoryIndex,
		@JsonProperty("parentCategoryId") String parentCategoryId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryAuthor = categoryAuthor;
		this.categoryIndex = categoryIndex;
		this.parentCategoryId = parentCategoryId;
	}

	public CategoryCreationData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public CategoryCreationData withCategoryId(String categoryId) {
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
	public CategoryCreationData withCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}
	
	@JsonProperty
	public String getCategoryAuthor() {
		return this.categoryAuthor;
	}
	public void setCategoryAuthor(String categoryAuthor) {
		this.categoryAuthor = categoryAuthor;
	}
	public CategoryCreationData withCategoryAuthor(String categoryAuthor) {
		this.categoryAuthor = categoryAuthor;
		return this;
	}
	
	@JsonProperty
	public Integer getCategoryIndex() {
		return this.categoryIndex;
	}
	public void setCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
	}
	public CategoryCreationData withCategoryIndex(Integer categoryIndex) {
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
	public CategoryCreationData withParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new CategoryCreationPresentationalData(
			this.categoryId,
			this.categoryName,
			this.categoryAuthor,
			this.categoryIndex,
			this.parentCategoryId
		);
	}

}

/*       S.D.G.       */
