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




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.IBoxUpdateModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractBoxUpdateData extends AbstractData implements IBoxUpdateData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractBoxUpdateData.class);
	
	@NotNull
	private String userId;
	
	@NotNull
	private String boxId;
	
	private Integer maxInterval;
	
	private Integer maxCardsPerDay;
	
	private String categoryName;
	
	private Boolean dictionaryLookup = false;
	
	private String givenLanguage;
	
	private String wantedLanguage;
	
	private String categoryId;
	

	public AbstractBoxUpdateData(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("maxInterval") Integer maxInterval,
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup,
		@JsonProperty("givenLanguage") String givenLanguage,
		@JsonProperty("wantedLanguage") String wantedLanguage,
		@JsonProperty("categoryId") String categoryId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.boxId = boxId;
		this.maxInterval = maxInterval;
		this.maxCardsPerDay = maxCardsPerDay;
		this.categoryName = categoryName;
		this.dictionaryLookup = dictionaryLookup;
		this.givenLanguage = givenLanguage;
		this.wantedLanguage = wantedLanguage;
		this.categoryId = categoryId;
	}

	public AbstractBoxUpdateData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
		public String getUserId() {
			return this.userId;
		}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IBoxUpdateData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
		public String getBoxId() {
			return this.boxId;
		}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IBoxUpdateData withBoxId(String boxId) {
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
	public IBoxUpdateData withMaxInterval(Integer maxInterval) {
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
	public IBoxUpdateData withMaxCardsPerDay(Integer maxCardsPerDay) {
		this.maxCardsPerDay = maxCardsPerDay;
		return this;
	}
	
	@JsonProperty
		public String getCategoryName() {
			return this.categoryName;
		}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public IBoxUpdateData withCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}
	
	@JsonProperty
		public Boolean getDictionaryLookup() {
			return this.dictionaryLookup;
		}
	public void setDictionaryLookup(Boolean dictionaryLookup) {
		this.dictionaryLookup = dictionaryLookup;
	}
	public IBoxUpdateData withDictionaryLookup(Boolean dictionaryLookup) {
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
	public IBoxUpdateData withGivenLanguage(String givenLanguage) {
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
	public IBoxUpdateData withWantedLanguage(String wantedLanguage) {
		this.wantedLanguage = wantedLanguage;
		return this;
	}
	
	@JsonProperty
		public String getCategoryId() {
			return this.categoryId;
		}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public IBoxUpdateData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	
	
}




/******* S.D.G. *******/



