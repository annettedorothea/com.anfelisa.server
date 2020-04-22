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

import org.joda.time.DateTime;
import java.util.List;

@SuppressWarnings("unused")
public class BoxListTestData {
	
	private String uuid;

	private java.util.List<com.anfelisa.box.data.BoxViewTestData> boxList;
	
	private String userId;
	
	private String today;
	

	public BoxListTestData(
		@JsonProperty("boxList") java.util.List<com.anfelisa.box.data.BoxViewTestData> boxList, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("today") String today, 
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
		this.boxList = boxList;
		this.userId = userId;
		this.today = today;
	}

	public BoxListTestData(
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
	}

	public BoxListTestData() {
	}

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	public java.util.List<com.anfelisa.box.data.BoxViewTestData> getBoxList() {
		return this.boxList;
	}
	public void setBoxList(java.util.List<com.anfelisa.box.data.BoxViewTestData> boxList) {
		this.boxList = boxList;
	}
	
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getToday() {
		return this.today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	
}




/******* S.D.G. *******/



