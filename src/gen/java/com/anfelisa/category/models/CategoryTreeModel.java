/* 
 * Copyright (c) 2020, Annette Pohl, Koblenz, Germany
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
 *
 * generated with de.acegen 0.9.7
 *
 */




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


	public CategoryTreeModel() {
	}

	public CategoryTreeModel(
		@JsonProperty("rootCategory") com.anfelisa.category.models.ICategoryTreeItemModel rootCategory,
		@JsonProperty("userId") String userId,
		@JsonProperty("rootCategoryId") String rootCategoryId
	) {
		this.rootCategory = rootCategory;
		this.userId = userId;
		this.rootCategoryId = rootCategoryId;
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
	
}



/******* S.D.G. *******/



