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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class LoadNextCardResponse implements ILoadNextCardResponse {
	
	private String cardId;
	
	private String categoryId;
	
	private Integer count;
	
	private String given;
	
	private String image;
	
	private Integer lastQuality;
	
	private String rootCategoryId;
	
	private String scheduledCardId;
	
	private String reinforceCardId;
	
	private java.time.LocalDateTime scheduledDate;
	
	private java.time.LocalDateTime scoredDate;
	
	private String wanted;
	
	private Integer openTodaysCards;
	
	private Integer allTodaysCards;
	
	public LoadNextCardResponse() {
	}
	
	public LoadNextCardResponse(com.anfelisa.box.models.INextCardModel data) {
		cardId = data.getCardId();
		categoryId = data.getCategoryId();
		count = data.getCount();
		given = data.getGiven();
		image = data.getImage();
		lastQuality = data.getLastQuality();
		rootCategoryId = data.getRootCategoryId();
		scheduledCardId = data.getScheduledCardId();
		reinforceCardId = data.getReinforceCardId();
		scheduledDate = data.getScheduledDate();
		scoredDate = data.getScoredDate();
		wanted = data.getWanted();
		openTodaysCards = data.getOpenTodaysCards();
		allTodaysCards = data.getAllTodaysCards();
	}
	
	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	
	@JsonProperty
	public Integer getCount() {
		return this.count;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	
	@JsonProperty
	public String getImage() {
		return this.image;
	}
	
	@JsonProperty
	public Integer getLastQuality() {
		return this.lastQuality;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	
	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	
	@JsonProperty
	public String getReinforceCardId() {
		return this.reinforceCardId;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public java.time.LocalDateTime getScheduledDate() {
		return this.scheduledDate;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public java.time.LocalDateTime getScoredDate() {
		return this.scoredDate;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	
	@JsonProperty
	public Integer getOpenTodaysCards() {
		return this.openTodaysCards;
	}
	
	@JsonProperty
	public Integer getAllTodaysCards() {
		return this.allTodaysCards;
	}
	
}



/******* S.D.G. *******/



