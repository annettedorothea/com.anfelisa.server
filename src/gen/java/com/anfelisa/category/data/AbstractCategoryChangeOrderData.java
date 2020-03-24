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

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.category.models.ICategoryChangeOrderModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractCategoryChangeOrderData extends AbstractData implements ICategoryChangeOrderData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCategoryChangeOrderData.class);
	
	private String movedCategoryId;
	
	private String targetCategoryId;
	
	private String userId;
	
	private java.util.List<com.anfelisa.category.models.ICategoryModel> updatedIndices;
	

	public AbstractCategoryChangeOrderData(
		@JsonProperty("movedCategoryId") String movedCategoryId,
		@JsonProperty("targetCategoryId") String targetCategoryId,
		@JsonProperty("userId") String userId,
		@JsonProperty("updatedIndices") java.util.List<com.anfelisa.category.models.ICategoryModel> updatedIndices
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.movedCategoryId = movedCategoryId;
		this.targetCategoryId = targetCategoryId;
		this.userId = userId;
		this.updatedIndices = updatedIndices;
	}

	public AbstractCategoryChangeOrderData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
		public String getMovedCategoryId() {
			return this.movedCategoryId;
		}
	public void setMovedCategoryId(String movedCategoryId) {
		this.movedCategoryId = movedCategoryId;
	}
	public ICategoryChangeOrderData withMovedCategoryId(String movedCategoryId) {
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
	public ICategoryChangeOrderData withTargetCategoryId(String targetCategoryId) {
		this.targetCategoryId = targetCategoryId;
		return this;
	}
	
	@JsonProperty
		public String getUserId() {
			return this.userId;
		}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ICategoryChangeOrderData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
		public java.util.List<com.anfelisa.category.models.ICategoryModel> getUpdatedIndices() {
			return this.updatedIndices;
		}
	public void setUpdatedIndices(java.util.List<com.anfelisa.category.models.ICategoryModel> updatedIndices) {
		this.updatedIndices = updatedIndices;
	}
	public ICategoryChangeOrderData withUpdatedIndices(java.util.List<com.anfelisa.category.models.ICategoryModel> updatedIndices) {
		this.updatedIndices = updatedIndices;
		return this;
	}
	
	
	
}




/******* S.D.G. *******/



