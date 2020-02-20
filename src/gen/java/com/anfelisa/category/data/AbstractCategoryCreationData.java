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
import com.anfelisa.category.models.ICategoryCreationModel;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;
import com.anfelisa.box.models.IBoxModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractCategoryCreationData extends AbstractData implements ICategoryCreationData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCategoryCreationData.class);
	
	private String username;
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private String categoryName;
	
	@NotNull
	private String categoryAuthor;
	
	@NotNull
	private Integer categoryIndex;
	
	private String parentCategoryId;
	
	private String rootCategoryId;
	
	private Boolean dictionaryLookup = false;
	
	private String givenLanguage;
	
	private String wantedLanguage;
	
	@NotNull
	private String userId;
	
	private Boolean editable = false;
	
	@NotNull
	private String boxId;
	
	private Integer maxInterval;
	
	@NotNull
	private Integer maxCardsPerDay;
	

	public AbstractCategoryCreationData(
		@JsonProperty("username") String username,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryAuthor") String categoryAuthor,
		@JsonProperty("categoryIndex") Integer categoryIndex,
		@JsonProperty("parentCategoryId") String parentCategoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup,
		@JsonProperty("givenLanguage") String givenLanguage,
		@JsonProperty("wantedLanguage") String wantedLanguage,
		@JsonProperty("userId") String userId,
		@JsonProperty("editable") Boolean editable,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("maxInterval") Integer maxInterval,
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.username = username;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryAuthor = categoryAuthor;
		this.categoryIndex = categoryIndex;
		this.parentCategoryId = parentCategoryId;
		this.rootCategoryId = rootCategoryId;
		this.dictionaryLookup = dictionaryLookup;
		this.givenLanguage = givenLanguage;
		this.wantedLanguage = wantedLanguage;
		this.userId = userId;
		this.editable = editable;
		this.boxId = boxId;
		this.maxInterval = maxInterval;
		this.maxCardsPerDay = maxCardsPerDay;
	}

	public AbstractCategoryCreationData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
		public String getUsername() {
			return this.username;
		}
	public void setUsername(String username) {
		this.username = username;
	}
	public ICategoryCreationData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
		public String getCategoryId() {
			return this.categoryId;
		}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public ICategoryCreationData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
		public String getCategoryName() {
			return this.categoryName;
		}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public ICategoryCreationData withCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}
	
	@JsonProperty
		public String getCategoryAuthor() {
			return this.categoryAuthor;
		}
	public void setCategoryAuthor(String categoryAuthor) {
		this.categoryAuthor = categoryAuthor;
	}
	public ICategoryCreationData withCategoryAuthor(String categoryAuthor) {
		this.categoryAuthor = categoryAuthor;
		return this;
	}
	
	@JsonProperty
		public Integer getCategoryIndex() {
			return this.categoryIndex;
		}
	public void setCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
	}
	public ICategoryCreationData withCategoryIndex(Integer categoryIndex) {
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
	public ICategoryCreationData withParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
		return this;
	}
	
	@JsonProperty
		public String getRootCategoryId() {
			return this.rootCategoryId;
		}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	public ICategoryCreationData withRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
		return this;
	}
	
	@JsonProperty
		public Boolean getDictionaryLookup() {
			return this.dictionaryLookup;
		}
	public void setDictionaryLookup(Boolean dictionaryLookup) {
		this.dictionaryLookup = dictionaryLookup;
	}
	public ICategoryCreationData withDictionaryLookup(Boolean dictionaryLookup) {
		this.dictionaryLookup = dictionaryLookup;
		return this;
	}
	
	@JsonProperty
		public String getGivenLanguage() {
			return this.givenLanguage;
		}
	public void setGivenLanguage(String givenLanguage) {
		this.givenLanguage = givenLanguage;
	}
	public ICategoryCreationData withGivenLanguage(String givenLanguage) {
		this.givenLanguage = givenLanguage;
		return this;
	}
	
	@JsonProperty
		public String getWantedLanguage() {
			return this.wantedLanguage;
		}
	public void setWantedLanguage(String wantedLanguage) {
		this.wantedLanguage = wantedLanguage;
	}
	public ICategoryCreationData withWantedLanguage(String wantedLanguage) {
		this.wantedLanguage = wantedLanguage;
		return this;
	}
	
	@JsonProperty
		public String getUserId() {
			return this.userId;
		}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ICategoryCreationData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
		public Boolean getEditable() {
			return this.editable;
		}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	public ICategoryCreationData withEditable(Boolean editable) {
		this.editable = editable;
		return this;
	}
	
	@JsonProperty
		public String getBoxId() {
			return this.boxId;
		}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public ICategoryCreationData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
		public Integer getMaxInterval() {
			return this.maxInterval;
		}
	public void setMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
	}
	public ICategoryCreationData withMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
		return this;
	}
	
	@JsonProperty
		public Integer getMaxCardsPerDay() {
			return this.maxCardsPerDay;
		}
	public void setMaxCardsPerDay(Integer maxCardsPerDay) {
		this.maxCardsPerDay = maxCardsPerDay;
	}
	public ICategoryCreationData withMaxCardsPerDay(Integer maxCardsPerDay) {
		this.maxCardsPerDay = maxCardsPerDay;
		return this;
	}
	
	
	public void mapFrom(com.anfelisa.category.models.ICategoryModel model) {
		this.categoryId = model.getCategoryId();
		this.categoryName = model.getCategoryName();
		this.categoryAuthor = model.getCategoryAuthor();
		this.categoryIndex = model.getCategoryIndex();
		this.parentCategoryId = model.getParentCategoryId();
		this.rootCategoryId = model.getRootCategoryId();
		this.dictionaryLookup = model.getDictionaryLookup();
		this.givenLanguage = model.getGivenLanguage();
		this.wantedLanguage = model.getWantedLanguage();
	}
	public void mapFrom(com.anfelisa.category.models.IUserAccessToCategoryModel model) {
		this.categoryId = model.getCategoryId();
		this.userId = model.getUserId();
		this.editable = model.getEditable();
	}
	public void mapFrom(com.anfelisa.box.models.IBoxModel model) {
		this.boxId = model.getBoxId();
		this.userId = model.getUserId();
		this.categoryId = model.getCategoryId();
		this.maxInterval = model.getMaxInterval();
		this.maxCardsPerDay = model.getMaxCardsPerDay();
	}
	
}




/******* S.D.G. *******/



