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

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import de.acegen.IDataContainer;

@SuppressWarnings("all")
public class LoadNextCardResponse implements ILoadNextCardResponse {
	
	@NotNull
	private String cardId;
	
	private String categoryId;
	
	@NotNull
	private Integer count;
	
	private String given;
	
	private String image;
	
	private Integer lastQuality;
	
	private String rootCategoryId;
	
	@NotNull
	private String scheduledCardId;
	
	@NotNull
	private String reinforceCardId;
	
	@NotNull
	private org.joda.time.DateTime scheduledDate;
	
	private org.joda.time.DateTime scoredDate;
	
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
		public org.joda.time.DateTime getScheduledDate() {
			return this.scheduledDate;
		}
	
	@JsonProperty
		public org.joda.time.DateTime getScoredDate() {
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



