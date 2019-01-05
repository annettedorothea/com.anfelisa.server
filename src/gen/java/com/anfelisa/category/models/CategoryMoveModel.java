package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CategoryMoveModel implements ICategoryMoveModel {

	private String movedCategoryId;
	
	private String targetCategoryId;
	
	private com.anfelisa.category.models.ICategoryModel movedCategory;
	
	private String userId;
	

	public CategoryMoveModel(
		@JsonProperty("movedCategoryId") String movedCategoryId,
		@JsonProperty("targetCategoryId") String targetCategoryId,
		@JsonProperty("movedCategory") com.anfelisa.category.models.ICategoryModel movedCategory,
		@JsonProperty("userId") String userId
	) {
		this.movedCategoryId = movedCategoryId;
		this.targetCategoryId = targetCategoryId;
		this.movedCategory = movedCategory;
		this.userId = userId;
	}

	@JsonProperty
	public String getMovedCategoryId() {
		return this.movedCategoryId;
	}
	public void setMovedCategoryId(String movedCategoryId) {
		this.movedCategoryId = movedCategoryId;
	}
	
	@JsonProperty
	public String getTargetCategoryId() {
		return this.targetCategoryId;
	}
	public void setTargetCategoryId(String targetCategoryId) {
		this.targetCategoryId = targetCategoryId;
	}
	
	@JsonProperty
	public com.anfelisa.category.models.ICategoryModel getMovedCategory() {
		return this.movedCategory;
	}
	public void setMovedCategory(com.anfelisa.category.models.ICategoryModel movedCategory) {
		this.movedCategory = movedCategory;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}

/*       S.D.G.       */
