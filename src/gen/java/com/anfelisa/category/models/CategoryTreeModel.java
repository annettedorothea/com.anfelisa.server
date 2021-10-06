/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class CategoryTreeModel implements ICategoryTreeModel {

	private com.anfelisa.category.models.ICategoryTreeItemModel rootCategory;

	private String userId;

	private String rootCategoryId;

	private Boolean filterNonScheduled = false;

	private Integer priority;

	private Boolean editable = false;

	private Boolean reverse = false;

	private Boolean reverseBoxExists = false;

	private String boxId;


	public CategoryTreeModel() {
	}

	public CategoryTreeModel(
		@JsonProperty("rootCategory") com.anfelisa.category.models.ICategoryTreeItemModel rootCategory,
		@JsonProperty("userId") String userId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("filterNonScheduled") Boolean filterNonScheduled,
		@JsonProperty("priority") Integer priority,
		@JsonProperty("editable") Boolean editable,
		@JsonProperty("reverse") Boolean reverse,
		@JsonProperty("reverseBoxExists") Boolean reverseBoxExists,
		@JsonProperty("boxId") String boxId
	) {
		this.rootCategory = rootCategory;
		this.userId = userId;
		this.rootCategoryId = rootCategoryId;
		this.filterNonScheduled = filterNonScheduled;
		this.priority = priority;
		this.editable = editable;
		this.reverse = reverse;
		this.reverseBoxExists = reverseBoxExists;
		this.boxId = boxId;
	}

	@JsonProperty
	public com.anfelisa.category.models.ICategoryTreeItemModel getRootCategory() {
		return this.rootCategory;
	}
	public void setRootCategory(com.anfelisa.category.models.ICategoryTreeItemModel rootCategory) {
		this.rootCategory = rootCategory;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	
	@JsonProperty
	public Boolean getFilterNonScheduled() {
		return this.filterNonScheduled;
	}
	public void setFilterNonScheduled(Boolean filterNonScheduled) {
		this.filterNonScheduled = filterNonScheduled;
	}
	
	@JsonProperty
	public Integer getPriority() {
		return this.priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	@JsonProperty
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	
	@JsonProperty
	public Boolean getReverse() {
		return this.reverse;
	}
	public void setReverse(Boolean reverse) {
		this.reverse = reverse;
	}
	
	@JsonProperty
	public Boolean getReverseBoxExists() {
		return this.reverseBoxExists;
	}
	public void setReverseBoxExists(Boolean reverseBoxExists) {
		this.reverseBoxExists = reverseBoxExists;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	

	public ICategoryTreeModel deepCopy() {
		ICategoryTreeModel copy = new CategoryTreeModel();
		copy.setRootCategory(this.getRootCategory().deepCopy());
		copy.setUserId(this.getUserId());
		copy.setRootCategoryId(this.getRootCategoryId());
		copy.setFilterNonScheduled(this.getFilterNonScheduled());
		copy.setPriority(this.getPriority());
		copy.setEditable(this.getEditable());
		copy.setReverse(this.getReverse());
		copy.setReverseBoxExists(this.getReverseBoxExists());
		copy.setBoxId(this.getBoxId());
		return copy;
	}

}



/******* S.D.G. *******/



