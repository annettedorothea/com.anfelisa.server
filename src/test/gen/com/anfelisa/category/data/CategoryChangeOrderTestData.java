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




package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.joda.time.DateTime;
import java.util.List;

@SuppressWarnings("unused")
public class CategoryChangeOrderTestData {
	
	private String uuid;

	private String movedCategoryId;
	
	private String targetCategoryId;
	
	private String userId;
	
	private java.util.List<com.anfelisa.category.data.CategoryTestData> updatedIndices;
	

	public CategoryChangeOrderTestData(
		@JsonProperty("movedCategoryId") String movedCategoryId, 
		@JsonProperty("targetCategoryId") String targetCategoryId, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("updatedIndices") java.util.List<com.anfelisa.category.data.CategoryTestData> updatedIndices, 
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
		this.movedCategoryId = movedCategoryId;
		this.targetCategoryId = targetCategoryId;
		this.userId = userId;
		this.updatedIndices = updatedIndices;
	}

	public CategoryChangeOrderTestData(
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
	}

	public CategoryChangeOrderTestData() {
	}

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	public String getMovedCategoryId() {
		return this.movedCategoryId;
	}
	public void setMovedCategoryId(String movedCategoryId) {
		this.movedCategoryId = movedCategoryId;
	}
	
	public String getTargetCategoryId() {
		return this.targetCategoryId;
	}
	public void setTargetCategoryId(String targetCategoryId) {
		this.targetCategoryId = targetCategoryId;
	}
	
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public java.util.List<com.anfelisa.category.data.CategoryTestData> getUpdatedIndices() {
		return this.updatedIndices;
	}
	public void setUpdatedIndices(java.util.List<com.anfelisa.category.data.CategoryTestData> updatedIndices) {
		this.updatedIndices = updatedIndices;
	}
	
}




/******* S.D.G. *******/



