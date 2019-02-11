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
import com.anfelisa.category.models.ICategoryTreeRootItemModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractCategoryTreeRootItemData extends AbstractData implements ICategoryTreeRootItemData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCategoryTreeRootItemData.class);
	
	private String categoryId;
	
	private String categoryName;
	
	private Integer categoryIndex;
	
	private Boolean empty = false;
	
	private Boolean editable = false;
	
	private Boolean hasBox = false;
	
	private Boolean dictionaryLookup = false;
	
	private String givenLanguage;
	
	private String wantedLanguage;
	
	private String rootCategoryId;
	
	private java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories;
	

	public AbstractCategoryTreeRootItemData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryIndex") Integer categoryIndex,
		@JsonProperty("empty") Boolean empty,
		@JsonProperty("editable") Boolean editable,
		@JsonProperty("hasBox") Boolean hasBox,
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup,
		@JsonProperty("givenLanguage") String givenLanguage,
		@JsonProperty("wantedLanguage") String wantedLanguage,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("childCategories") java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryIndex = categoryIndex;
		this.empty = empty;
		this.editable = editable;
		this.hasBox = hasBox;
		this.dictionaryLookup = dictionaryLookup;
		this.givenLanguage = givenLanguage;
		this.wantedLanguage = wantedLanguage;
		this.rootCategoryId = rootCategoryId;
		this.childCategories = childCategories;
	}

	public AbstractCategoryTreeRootItemData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public ICategoryTreeRootItemData withCategoryId(String categoryId) {
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
	public ICategoryTreeRootItemData withCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}
	
	@JsonProperty
	public Integer getCategoryIndex() {
		return this.categoryIndex;
	}
	public void setCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
	}
	public ICategoryTreeRootItemData withCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
		return this;
	}
	
	@JsonProperty
	public Boolean getEmpty() {
		return this.empty;
	}
	public void setEmpty(Boolean empty) {
		this.empty = empty;
	}
	public ICategoryTreeRootItemData withEmpty(Boolean empty) {
		this.empty = empty;
		return this;
	}
	
	@JsonProperty
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	public ICategoryTreeRootItemData withEditable(Boolean editable) {
		this.editable = editable;
		return this;
	}
	
	@JsonProperty
	public Boolean getHasBox() {
		return this.hasBox;
	}
	public void setHasBox(Boolean hasBox) {
		this.hasBox = hasBox;
	}
	public ICategoryTreeRootItemData withHasBox(Boolean hasBox) {
		this.hasBox = hasBox;
		return this;
	}
	
	@JsonProperty
	public Boolean getDictionaryLookup() {
		return this.dictionaryLookup;
	}
	public void setDictionaryLookup(Boolean dictionaryLookup) {
		this.dictionaryLookup = dictionaryLookup;
	}
	public ICategoryTreeRootItemData withDictionaryLookup(Boolean dictionaryLookup) {
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
	public ICategoryTreeRootItemData withGivenLanguage(String givenLanguage) {
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
	public ICategoryTreeRootItemData withWantedLanguage(String wantedLanguage) {
		this.wantedLanguage = wantedLanguage;
		return this;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	public ICategoryTreeRootItemData withRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> getChildCategories() {
		return this.childCategories;
	}
	public void setChildCategories(java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories) {
		this.childCategories = childCategories;
	}
	public ICategoryTreeRootItemData withChildCategories(java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories) {
		this.childCategories = childCategories;
		return this;
	}
	
	
	
	public List<String> equalsPrimitiveTypes(com.anfelisa.category.models.ICategoryTreeRootItemModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getCategoryId() == null && other.getCategoryId() == null) && !this.getCategoryId().equals(other.getCategoryId())) {
			differingAttributes.add("categoryId: " + this.getCategoryId() + " " + other.getCategoryId());
		}
		if (!(this.getCategoryName() == null && other.getCategoryName() == null) && !this.getCategoryName().equals(other.getCategoryName())) {
			differingAttributes.add("categoryName: " + this.getCategoryName() + " " + other.getCategoryName());
		}
		if (!(this.getCategoryIndex() == null && other.getCategoryIndex() == null) && !this.getCategoryIndex().equals(other.getCategoryIndex())) {
			differingAttributes.add("categoryIndex: " + this.getCategoryIndex() + " " + other.getCategoryIndex());
		}
		if (!(this.getEmpty() == null && other.getEmpty() == null) && !this.getEmpty().equals(other.getEmpty())) {
			differingAttributes.add("empty: " + this.getEmpty() + " " + other.getEmpty());
		}
		if (!(this.getEditable() == null && other.getEditable() == null) && !this.getEditable().equals(other.getEditable())) {
			differingAttributes.add("editable: " + this.getEditable() + " " + other.getEditable());
		}
		if (!(this.getHasBox() == null && other.getHasBox() == null) && !this.getHasBox().equals(other.getHasBox())) {
			differingAttributes.add("hasBox: " + this.getHasBox() + " " + other.getHasBox());
		}
		if (!(this.getDictionaryLookup() == null && other.getDictionaryLookup() == null) && !this.getDictionaryLookup().equals(other.getDictionaryLookup())) {
			differingAttributes.add("dictionaryLookup: " + this.getDictionaryLookup() + " " + other.getDictionaryLookup());
		}
		if (!(this.getGivenLanguage() == null && other.getGivenLanguage() == null) && !this.getGivenLanguage().equals(other.getGivenLanguage())) {
			differingAttributes.add("givenLanguage: " + this.getGivenLanguage() + " " + other.getGivenLanguage());
		}
		if (!(this.getWantedLanguage() == null && other.getWantedLanguage() == null) && !this.getWantedLanguage().equals(other.getWantedLanguage())) {
			differingAttributes.add("wantedLanguage: " + this.getWantedLanguage() + " " + other.getWantedLanguage());
		}
		if (!(this.getRootCategoryId() == null && other.getRootCategoryId() == null) && !this.getRootCategoryId().equals(other.getRootCategoryId())) {
			differingAttributes.add("rootCategoryId: " + this.getRootCategoryId() + " " + other.getRootCategoryId());
		}
		return differingAttributes;
	}
	
	
}




/******* S.D.G. *******/



