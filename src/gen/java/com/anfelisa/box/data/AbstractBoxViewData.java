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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.IBoxViewModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractBoxViewData extends AbstractData implements IBoxViewData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractBoxViewData.class);
	
	private Integer openTodaysCards;
	
	@NotNull
	private String categoryName;
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private String boxId;
	

	public AbstractBoxViewData(
		@JsonProperty("openTodaysCards") Integer openTodaysCards,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("boxId") String boxId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.openTodaysCards = openTodaysCards;
		this.categoryName = categoryName;
		this.categoryId = categoryId;
		this.boxId = boxId;
	}

	public AbstractBoxViewData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public Integer getOpenTodaysCards() {
		return this.openTodaysCards;
	}
	public void setOpenTodaysCards(Integer openTodaysCards) {
		this.openTodaysCards = openTodaysCards;
	}
	public IBoxViewData withOpenTodaysCards(Integer openTodaysCards) {
		this.openTodaysCards = openTodaysCards;
		return this;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public IBoxViewData withCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public IBoxViewData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IBoxViewData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	
	
}




/******* S.D.G. *******/



