package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractCategoryMoveData extends AbstractData implements ICategoryMoveData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCategoryMoveData.class);
	
	private String movedCategoryId;
	
	private String targetCategoryId;
	
	private com.anfelisa.category.models.ICategoryModel movedCategory;
	
	@NotNull
	private Integer categoryIndexWhereRemoved;
	
	@NotNull
	private String parentCategoryIdWhereRemoved;
	
	private String userId;
	

	public AbstractCategoryMoveData(
		@JsonProperty("movedCategoryId") String movedCategoryId,
		@JsonProperty("targetCategoryId") String targetCategoryId,
		@JsonProperty("movedCategory") com.anfelisa.category.models.ICategoryModel movedCategory,
		@JsonProperty("categoryIndexWhereRemoved") Integer categoryIndexWhereRemoved,
		@JsonProperty("parentCategoryIdWhereRemoved") String parentCategoryIdWhereRemoved,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.movedCategoryId = movedCategoryId;
		this.targetCategoryId = targetCategoryId;
		this.movedCategory = movedCategory;
		this.categoryIndexWhereRemoved = categoryIndexWhereRemoved;
		this.parentCategoryIdWhereRemoved = parentCategoryIdWhereRemoved;
		this.userId = userId;
	}

	public AbstractCategoryMoveData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getMovedCategoryId() {
		return this.movedCategoryId;
	}
	public void setMovedCategoryId(String movedCategoryId) {
		this.movedCategoryId = movedCategoryId;
	}
	public ICategoryMoveData withMovedCategoryId(String movedCategoryId) {
		this.movedCategoryId = movedCategoryId;
		return this;
	}
	
	@JsonProperty
	public String getTargetCategoryId() {
		return this.targetCategoryId;
	}
	public void setTargetCategoryId(String targetCategoryId) {
		this.targetCategoryId = targetCategoryId;
	}
	public ICategoryMoveData withTargetCategoryId(String targetCategoryId) {
		this.targetCategoryId = targetCategoryId;
		return this;
	}
	
	@JsonProperty
	public com.anfelisa.category.models.ICategoryModel getMovedCategory() {
		return this.movedCategory;
	}
	public void setMovedCategory(com.anfelisa.category.models.ICategoryModel movedCategory) {
		this.movedCategory = movedCategory;
	}
	public ICategoryMoveData withMovedCategory(com.anfelisa.category.models.ICategoryModel movedCategory) {
		this.movedCategory = movedCategory;
		return this;
	}
	
	@JsonProperty
	public Integer getCategoryIndexWhereRemoved() {
		return this.categoryIndexWhereRemoved;
	}
	public void setCategoryIndexWhereRemoved(Integer categoryIndexWhereRemoved) {
		this.categoryIndexWhereRemoved = categoryIndexWhereRemoved;
	}
	public ICategoryMoveData withCategoryIndexWhereRemoved(Integer categoryIndexWhereRemoved) {
		this.categoryIndexWhereRemoved = categoryIndexWhereRemoved;
		return this;
	}
	
	@JsonProperty
	public String getParentCategoryIdWhereRemoved() {
		return this.parentCategoryIdWhereRemoved;
	}
	public void setParentCategoryIdWhereRemoved(String parentCategoryIdWhereRemoved) {
		this.parentCategoryIdWhereRemoved = parentCategoryIdWhereRemoved;
	}
	public ICategoryMoveData withParentCategoryIdWhereRemoved(String parentCategoryIdWhereRemoved) {
		this.parentCategoryIdWhereRemoved = parentCategoryIdWhereRemoved;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ICategoryMoveData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
}

/*       S.D.G.       */