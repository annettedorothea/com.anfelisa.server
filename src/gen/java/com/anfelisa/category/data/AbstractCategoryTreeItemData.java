package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

@SuppressWarnings("unused")
public abstract class AbstractCategoryTreeItemData extends AbstractData implements ICategoryTreeItemData {
	
	private String categoryId;
	
	private String categoryName;
	
	private Integer categoryIndex;
	
	private Boolean empty = false;
	
	private Boolean editable = false;
	
	private java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories;
	

	public AbstractCategoryTreeItemData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryIndex") Integer categoryIndex,
		@JsonProperty("empty") Boolean empty,
		@JsonProperty("editable") Boolean editable,
		@JsonProperty("childCategories") java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryIndex = categoryIndex;
		this.empty = empty;
		this.editable = editable;
		this.childCategories = childCategories;
	}

	public AbstractCategoryTreeItemData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@JsonProperty
	public Integer getCategoryIndex() {
		return this.categoryIndex;
	}
	public void setCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
	}
	
	@JsonProperty
	public Boolean getEmpty() {
		return this.empty;
	}
	public void setEmpty(Boolean empty) {
		this.empty = empty;
	}
	
	@JsonProperty
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> getChildCategories() {
		return this.childCategories;
	}
	public void setChildCategories(java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories) {
		this.childCategories = childCategories;
	}
	
}

/*       S.D.G.       */
