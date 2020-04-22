/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;

@SuppressWarnings("all")
public class CategoryMoveModel implements ICategoryMoveModel {

	private String movedCategoryId;
	
	private String targetCategoryId;
	
	private com.anfelisa.category.models.ICategoryModel movedCategory;
	
	@NotNull
	private Integer categoryIndexWhereRemoved;
	
	@NotNull
	private String parentCategoryIdWhereRemoved;
	
	private String userId;
	

	public CategoryMoveModel() {
	}

	public CategoryMoveModel(
		@JsonProperty("movedCategoryId") String movedCategoryId,
		@JsonProperty("targetCategoryId") String targetCategoryId,
		@JsonProperty("movedCategory") com.anfelisa.category.models.ICategoryModel movedCategory,
		@JsonProperty("categoryIndexWhereRemoved") Integer categoryIndexWhereRemoved,
		@JsonProperty("parentCategoryIdWhereRemoved") String parentCategoryIdWhereRemoved,
		@JsonProperty("userId") String userId
	) {
		this.movedCategoryId = movedCategoryId;
		this.targetCategoryId = targetCategoryId;
		this.movedCategory = movedCategory;
		this.categoryIndexWhereRemoved = categoryIndexWhereRemoved;
		this.parentCategoryIdWhereRemoved = parentCategoryIdWhereRemoved;
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
	public Integer getCategoryIndexWhereRemoved() {
		return this.categoryIndexWhereRemoved;
	}
	public void setCategoryIndexWhereRemoved(Integer categoryIndexWhereRemoved) {
		this.categoryIndexWhereRemoved = categoryIndexWhereRemoved;
	}
	
	@JsonProperty
	public String getParentCategoryIdWhereRemoved() {
		return this.parentCategoryIdWhereRemoved;
	}
	public void setParentCategoryIdWhereRemoved(String parentCategoryIdWhereRemoved) {
		this.parentCategoryIdWhereRemoved = parentCategoryIdWhereRemoved;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}




/******* S.D.G. *******/



