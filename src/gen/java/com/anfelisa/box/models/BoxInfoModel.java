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
public class BoxInfoModel implements IBoxInfoModel {

	private String userId;
	
	@NotNull
	private org.joda.time.DateTime today;
	
	private Integer todaysCards;
	
	private Integer totalCards;
	
	private Integer reinforceCards;
	
	private Integer myCards;
	
	private Integer daysBehindSchedule;
	
	@NotNull
	private String categoryName;
	
	private Integer maxInterval;
	
	private Integer maxCardsPerDay;
	
	private Integer quality0Count;
	
	private Integer quality1Count;
	
	private Integer quality2Count;
	
	private Integer quality3Count;
	
	private Integer quality4Count;
	
	private Integer quality5Count;
	
	@NotNull
	private String boxId;
	

	public BoxInfoModel() {
	}

	public BoxInfoModel(
		@JsonProperty("userId") String userId,
		@JsonProperty("today") org.joda.time.DateTime today,
		@JsonProperty("todaysCards") Integer todaysCards,
		@JsonProperty("totalCards") Integer totalCards,
		@JsonProperty("reinforceCards") Integer reinforceCards,
		@JsonProperty("myCards") Integer myCards,
		@JsonProperty("daysBehindSchedule") Integer daysBehindSchedule,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("maxInterval") Integer maxInterval,
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay,
		@JsonProperty("quality0Count") Integer quality0Count,
		@JsonProperty("quality1Count") Integer quality1Count,
		@JsonProperty("quality2Count") Integer quality2Count,
		@JsonProperty("quality3Count") Integer quality3Count,
		@JsonProperty("quality4Count") Integer quality4Count,
		@JsonProperty("quality5Count") Integer quality5Count,
		@JsonProperty("boxId") String boxId
	) {
		this.userId = userId;
		this.today = today;
		this.todaysCards = todaysCards;
		this.totalCards = totalCards;
		this.reinforceCards = reinforceCards;
		this.myCards = myCards;
		this.daysBehindSchedule = daysBehindSchedule;
		this.categoryName = categoryName;
		this.maxInterval = maxInterval;
		this.maxCardsPerDay = maxCardsPerDay;
		this.quality0Count = quality0Count;
		this.quality1Count = quality1Count;
		this.quality2Count = quality2Count;
		this.quality3Count = quality3Count;
		this.quality4Count = quality4Count;
		this.quality5Count = quality5Count;
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
	
	@JsonProperty
		public Integer getTodaysCards() {
			return this.todaysCards;
		}
	public void setTodaysCards(Integer todaysCards) {
		this.todaysCards = todaysCards;
	}
	
	@JsonProperty
		public Integer getTotalCards() {
			return this.totalCards;
		}
	public void setTotalCards(Integer totalCards) {
		this.totalCards = totalCards;
	}
	
	@JsonProperty
		public Integer getReinforceCards() {
			return this.reinforceCards;
		}
	public void setReinforceCards(Integer reinforceCards) {
		this.reinforceCards = reinforceCards;
	}
	
	@JsonProperty
		public Integer getMyCards() {
			return this.myCards;
		}
	public void setMyCards(Integer myCards) {
		this.myCards = myCards;
	}
	
	@JsonProperty
		public Integer getDaysBehindSchedule() {
			return this.daysBehindSchedule;
		}
	public void setDaysBehindSchedule(Integer daysBehindSchedule) {
		this.daysBehindSchedule = daysBehindSchedule;
	}
	
	@JsonProperty
		public String getCategoryName() {
			return this.categoryName;
		}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@JsonProperty
		public Integer getMaxInterval() {
			return this.maxInterval;
		}
	public void setMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
	}
	
	@JsonProperty
		public Integer getMaxCardsPerDay() {
			return this.maxCardsPerDay;
		}
	public void setMaxCardsPerDay(Integer maxCardsPerDay) {
		this.maxCardsPerDay = maxCardsPerDay;
	}
	
	@JsonProperty
		public Integer getQuality0Count() {
			return this.quality0Count;
		}
	public void setQuality0Count(Integer quality0Count) {
		this.quality0Count = quality0Count;
	}
	
	@JsonProperty
		public Integer getQuality1Count() {
			return this.quality1Count;
		}
	public void setQuality1Count(Integer quality1Count) {
		this.quality1Count = quality1Count;
	}
	
	@JsonProperty
		public Integer getQuality2Count() {
			return this.quality2Count;
		}
	public void setQuality2Count(Integer quality2Count) {
		this.quality2Count = quality2Count;
	}
	
	@JsonProperty
		public Integer getQuality3Count() {
			return this.quality3Count;
		}
	public void setQuality3Count(Integer quality3Count) {
		this.quality3Count = quality3Count;
	}
	
	@JsonProperty
		public Integer getQuality4Count() {
			return this.quality4Count;
		}
	public void setQuality4Count(Integer quality4Count) {
		this.quality4Count = quality4Count;
	}
	
	@JsonProperty
		public Integer getQuality5Count() {
			return this.quality5Count;
		}
	public void setQuality5Count(Integer quality5Count) {
		this.quality5Count = quality5Count;
	}
	
	@JsonProperty
		public String getBoxId() {
			return this.boxId;
		}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	
}




/******* S.D.G. *******/



