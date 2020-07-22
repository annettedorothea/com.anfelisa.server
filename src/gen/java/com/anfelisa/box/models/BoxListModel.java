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




package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class BoxListModel implements IBoxListModel {

	private java.util.List<com.anfelisa.box.models.IBoxViewModel> boxList;

	private String userId;

	private java.time.LocalDateTime todayAtMidnightInUTC;


	public BoxListModel() {
	}

	public BoxListModel(
		@JsonProperty("boxList") java.util.List<com.anfelisa.box.models.IBoxViewModel> boxList,
		@JsonProperty("userId") String userId,
		@JsonProperty("todayAtMidnightInUTC") java.time.LocalDateTime todayAtMidnightInUTC
	) {
		this.boxList = boxList;
		this.userId = userId;
		this.todayAtMidnightInUTC = todayAtMidnightInUTC;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxViewModel> getBoxList() {
		return this.boxList;
	}
	public void setBoxList(java.util.List<com.anfelisa.box.models.IBoxViewModel> boxList) {
		this.boxList = boxList;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public java.time.LocalDateTime getTodayAtMidnightInUTC() {
		return this.todayAtMidnightInUTC;
	}
	public void setTodayAtMidnightInUTC(java.time.LocalDateTime todayAtMidnightInUTC) {
		this.todayAtMidnightInUTC = todayAtMidnightInUTC;
	}
	
}



/******* S.D.G. *******/



