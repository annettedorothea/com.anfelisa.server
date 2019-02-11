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
import com.anfelisa.box.models.IPostponeCardsModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractPostponeCardsData extends AbstractData implements IPostponeCardsData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractPostponeCardsData.class);
	
	@NotNull
	private Integer days;
	
	@NotNull
	private String boxId;
	
	private String userId;
	
	@NotNull
	private org.joda.time.DateTime today;
	

	public AbstractPostponeCardsData(
		@JsonProperty("days") Integer days,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("userId") String userId,
		@JsonProperty("today") org.joda.time.DateTime today
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.days = days;
		this.boxId = boxId;
		this.userId = userId;
		this.today = today;
	}

	public AbstractPostponeCardsData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public Integer getDays() {
		return this.days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public IPostponeCardsData withDays(Integer days) {
		this.days = days;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IPostponeCardsData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IPostponeCardsData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getToday() {
		return this.today;
	}
	public void setToday(org.joda.time.DateTime today) {
		this.today = today;
	}
	public IPostponeCardsData withToday(org.joda.time.DateTime today) {
		this.today = today;
		return this;
	}
	
	
	
	public List<String> equalsPrimitiveTypes(com.anfelisa.box.models.IPostponeCardsModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getDays() == null && other.getDays() == null) && !this.getDays().equals(other.getDays())) {
			differingAttributes.add("days: " + this.getDays() + " " + other.getDays());
		}
		if (!(this.getBoxId() == null && other.getBoxId() == null) && !this.getBoxId().equals(other.getBoxId())) {
			differingAttributes.add("boxId: " + this.getBoxId() + " " + other.getBoxId());
		}
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		if (!(this.getToday() == null && other.getToday() == null) && !this.getToday().equals(other.getToday())) {
			differingAttributes.add("today: " + this.getToday() + " " + other.getToday());
		}
		return differingAttributes;
	}
	
	
}




/******* S.D.G. *******/



