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
import com.anfelisa.box.models.IBoxViewModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractBoxViewData extends AbstractData implements IBoxViewData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractBoxViewData.class);
	
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
	

	public AbstractBoxViewData(
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
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
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

	public AbstractBoxViewData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
		public Integer getTodaysCards() {
			return this.todaysCards;
		}
	public void setTodaysCards(Integer todaysCards) {
		this.todaysCards = todaysCards;
	}
	public IBoxViewData withTodaysCards(Integer todaysCards) {
		this.todaysCards = todaysCards;
		return this;
	}
	
	@JsonProperty
		public Integer getTotalCards() {
			return this.totalCards;
		}
	public void setTotalCards(Integer totalCards) {
		this.totalCards = totalCards;
	}
	public IBoxViewData withTotalCards(Integer totalCards) {
		this.totalCards = totalCards;
		return this;
	}
	
	@JsonProperty
		public Integer getReinforceCards() {
			return this.reinforceCards;
		}
	public void setReinforceCards(Integer reinforceCards) {
		this.reinforceCards = reinforceCards;
	}
	public IBoxViewData withReinforceCards(Integer reinforceCards) {
		this.reinforceCards = reinforceCards;
		return this;
	}
	
	@JsonProperty
		public Integer getMyCards() {
			return this.myCards;
		}
	public void setMyCards(Integer myCards) {
		this.myCards = myCards;
	}
	public IBoxViewData withMyCards(Integer myCards) {
		this.myCards = myCards;
		return this;
	}
	
	@JsonProperty
		public Integer getDaysBehindSchedule() {
			return this.daysBehindSchedule;
		}
	public void setDaysBehindSchedule(Integer daysBehindSchedule) {
		this.daysBehindSchedule = daysBehindSchedule;
	}
	public IBoxViewData withDaysBehindSchedule(Integer daysBehindSchedule) {
		this.daysBehindSchedule = daysBehindSchedule;
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
		public Integer getMaxInterval() {
			return this.maxInterval;
		}
	public void setMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
	}
	public IBoxViewData withMaxInterval(Integer maxInterval) {
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
	public IBoxViewData withMaxCardsPerDay(Integer maxCardsPerDay) {
		this.maxCardsPerDay = maxCardsPerDay;
		return this;
	}
	
	@JsonProperty
		public Integer getQuality0Count() {
			return this.quality0Count;
		}
	public void setQuality0Count(Integer quality0Count) {
		this.quality0Count = quality0Count;
	}
	public IBoxViewData withQuality0Count(Integer quality0Count) {
		this.quality0Count = quality0Count;
		return this;
	}
	
	@JsonProperty
		public Integer getQuality1Count() {
			return this.quality1Count;
		}
	public void setQuality1Count(Integer quality1Count) {
		this.quality1Count = quality1Count;
	}
	public IBoxViewData withQuality1Count(Integer quality1Count) {
		this.quality1Count = quality1Count;
		return this;
	}
	
	@JsonProperty
		public Integer getQuality2Count() {
			return this.quality2Count;
		}
	public void setQuality2Count(Integer quality2Count) {
		this.quality2Count = quality2Count;
	}
	public IBoxViewData withQuality2Count(Integer quality2Count) {
		this.quality2Count = quality2Count;
		return this;
	}
	
	@JsonProperty
		public Integer getQuality3Count() {
			return this.quality3Count;
		}
	public void setQuality3Count(Integer quality3Count) {
		this.quality3Count = quality3Count;
	}
	public IBoxViewData withQuality3Count(Integer quality3Count) {
		this.quality3Count = quality3Count;
		return this;
	}
	
	@JsonProperty
		public Integer getQuality4Count() {
			return this.quality4Count;
		}
	public void setQuality4Count(Integer quality4Count) {
		this.quality4Count = quality4Count;
	}
	public IBoxViewData withQuality4Count(Integer quality4Count) {
		this.quality4Count = quality4Count;
		return this;
	}
	
	@JsonProperty
		public Integer getQuality5Count() {
			return this.quality5Count;
		}
	public void setQuality5Count(Integer quality5Count) {
		this.quality5Count = quality5Count;
	}
	public IBoxViewData withQuality5Count(Integer quality5Count) {
		this.quality5Count = quality5Count;
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



