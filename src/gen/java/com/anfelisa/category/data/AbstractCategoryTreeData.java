/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.category.models.ICategoryTreeModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractCategoryTreeData extends AbstractData implements ICategoryTreeData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCategoryTreeData.class);
	
	private com.anfelisa.category.models.ICategoryTreeItemModel rootCategory;
	
	private String userId;
	
	private String rootCategoryId;
	
	private Boolean filterNonScheduled = false;
	
	private Integer priority;
	

	public AbstractCategoryTreeData(
		@JsonProperty("rootCategory") com.anfelisa.category.models.ICategoryTreeItemModel rootCategory,
		@JsonProperty("userId") String userId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("filterNonScheduled") Boolean filterNonScheduled,
		@JsonProperty("priority") Integer priority
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.rootCategory = rootCategory;
		this.userId = userId;
		this.rootCategoryId = rootCategoryId;
		this.filterNonScheduled = filterNonScheduled;
		this.priority = priority;
	}

	public AbstractCategoryTreeData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public com.anfelisa.category.models.ICategoryTreeItemModel getRootCategory() {
		return this.rootCategory;
	}
	public void setRootCategory(com.anfelisa.category.models.ICategoryTreeItemModel rootCategory) {
		this.rootCategory = rootCategory;
	}
	public ICategoryTreeData withRootCategory(com.anfelisa.category.models.ICategoryTreeItemModel rootCategory) {
		this.rootCategory = rootCategory;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ICategoryTreeData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	public ICategoryTreeData withRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
		return this;
	}
	
	@JsonProperty
	public Boolean getFilterNonScheduled() {
		return this.filterNonScheduled;
	}
	public void setFilterNonScheduled(Boolean filterNonScheduled) {
		this.filterNonScheduled = filterNonScheduled;
	}
	public ICategoryTreeData withFilterNonScheduled(Boolean filterNonScheduled) {
		this.filterNonScheduled = filterNonScheduled;
		return this;
	}
	
	@JsonProperty
	public Integer getPriority() {
		return this.priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public ICategoryTreeData withPriority(Integer priority) {
		this.priority = priority;
		return this;
	}
	
	
	
}



/******* S.D.G. *******/



