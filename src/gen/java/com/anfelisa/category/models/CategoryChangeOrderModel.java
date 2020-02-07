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
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CategoryChangeOrderModel implements ICategoryChangeOrderModel {

	private String movedCategoryId;
	
	private String targetCategoryId;
	
	private String userId;
	
	private java.util.List<com.anfelisa.category.models.ICategoryModel> updatedIndices;
	

	public CategoryChangeOrderModel() {
	}

	public CategoryChangeOrderModel(
		@JsonProperty("movedCategoryId") String movedCategoryId,
		@JsonProperty("targetCategoryId") String targetCategoryId,
		@JsonProperty("userId") String userId,
		@JsonProperty("updatedIndices") java.util.List<com.anfelisa.category.models.ICategoryModel> updatedIndices
	) {
		this.movedCategoryId = movedCategoryId;
		this.targetCategoryId = targetCategoryId;
		this.userId = userId;
		this.updatedIndices = updatedIndices;
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
		public String getUserId() {
			return this.userId;
		}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
		public java.util.List<com.anfelisa.category.models.ICategoryModel> getUpdatedIndices() {
			return this.updatedIndices;
		}
	public void setUpdatedIndices(java.util.List<com.anfelisa.category.models.ICategoryModel> updatedIndices) {
		this.updatedIndices = updatedIndices;
	}
	
	
}




/******* S.D.G. *******/


