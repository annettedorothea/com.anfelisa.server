package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.category.models.ICategoryDeleteModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractCategoryDeleteData extends AbstractData implements ICategoryDeleteData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCategoryDeleteData.class);
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private Integer categoryIndex;
	
	@NotNull
	private String parentCategoryId;
	
	private String userId;
	

	public AbstractCategoryDeleteData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryIndex") Integer categoryIndex,
		@JsonProperty("parentCategoryId") String parentCategoryId,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryId = categoryId;
		this.categoryIndex = categoryIndex;
		this.parentCategoryId = parentCategoryId;
		this.userId = userId;
	}

	public AbstractCategoryDeleteData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public ICategoryDeleteData withCategoryId(String categoryId) {
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
	public ICategoryDeleteData withCategoryIndex(Integer categoryIndex) {
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
	public ICategoryDeleteData withParentCategoryId(String parentCategoryId) {
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
	public ICategoryDeleteData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
	
	public List<String> equalsPrimitiveTypes(ICategoryDeleteModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getCategoryId() == null && other.getCategoryId() == null) && !this.getCategoryId().equals(other.getCategoryId())) {
			differingAttributes.add("categoryId: " + this.getCategoryId() + " " + other.getCategoryId());
		}
		if (!(this.getCategoryIndex() == null && other.getCategoryIndex() == null) && !this.getCategoryIndex().equals(other.getCategoryIndex())) {
			differingAttributes.add("categoryIndex: " + this.getCategoryIndex() + " " + other.getCategoryIndex());
		}
		if (!(this.getParentCategoryId() == null && other.getParentCategoryId() == null) && !this.getParentCategoryId().equals(other.getParentCategoryId())) {
			differingAttributes.add("parentCategoryId: " + this.getParentCategoryId() + " " + other.getParentCategoryId());
		}
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		return differingAttributes;
	}
	
	
}

/*       S.D.G.       */
