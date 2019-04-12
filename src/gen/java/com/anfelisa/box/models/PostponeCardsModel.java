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




package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PostponeCardsModel implements IPostponeCardsModel {

	@NotNull
	private Integer days;
	
	@NotNull
	private String boxId;
	
	private String userId;
	
	@NotNull
	private org.joda.time.DateTime today;
	

	public PostponeCardsModel() {
	}

	public PostponeCardsModel(
		@JsonProperty("days") Integer days,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("userId") String userId,
		@JsonProperty("today") org.joda.time.DateTime today
	) {
		this.days = days;
		this.boxId = boxId;
		this.userId = userId;
		this.today = today;
	}

	@JsonProperty
		public Integer getDays() {
			return this.days;
		}
	public void setDays(Integer days) {
		this.days = days;
	}
	
	@JsonProperty
		public String getBoxId() {
			return this.boxId;
		}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
		public String getUserId() {
			return this.userId;
		}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
		public org.joda.time.DateTime getToday() {
			return this.today;
		}
	public void setToday(org.joda.time.DateTime today) {
		this.today = today;
	}
	
	
}




/******* S.D.G. *******/



