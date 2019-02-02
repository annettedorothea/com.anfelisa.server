package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("all")
public class GetBoxResponse implements IGetBoxResponse {
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String categoryName;
	
	private Integer daysBehindSchedule;
	
	private Integer maxInterval;
	
	private Integer maxCardsPerDay;
	
	private Integer myCards;
	
	private Integer quality0Count;
	
	private Integer quality1Count;
	
	private Integer quality2Count;
	
	private Integer quality3Count;
	
	private Integer quality4Count;
	
	private Integer quality5Count;
	
	private Integer reinforceCards;
	
	private Integer todaysCards;
	
	private Integer totalCards;
	
	public GetBoxResponse() {
	}
	
	public GetBoxResponse(com.anfelisa.box.models.IBoxInfoModel data) {
		boxId = data.getBoxId();
		categoryName = data.getCategoryName();
		daysBehindSchedule = data.getDaysBehindSchedule();
		maxInterval = data.getMaxInterval();
		maxCardsPerDay = data.getMaxCardsPerDay();
		myCards = data.getMyCards();
		quality0Count = data.getQuality0Count();
		quality1Count = data.getQuality1Count();
		quality2Count = data.getQuality2Count();
		quality3Count = data.getQuality3Count();
		quality4Count = data.getQuality4Count();
		quality5Count = data.getQuality5Count();
		reinforceCards = data.getReinforceCards();
		todaysCards = data.getTodaysCards();
		totalCards = data.getTotalCards();
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	
	@JsonProperty
	public Integer getDaysBehindSchedule() {
		return this.daysBehindSchedule;
	}
	
	@JsonProperty
	public Integer getMaxInterval() {
		return this.maxInterval;
	}
	
	@JsonProperty
	public Integer getMaxCardsPerDay() {
		return this.maxCardsPerDay;
	}
	
	@JsonProperty
	public Integer getMyCards() {
		return this.myCards;
	}
	
	@JsonProperty
	public Integer getQuality0Count() {
		return this.quality0Count;
	}
	
	@JsonProperty
	public Integer getQuality1Count() {
		return this.quality1Count;
	}
	
	@JsonProperty
	public Integer getQuality2Count() {
		return this.quality2Count;
	}
	
	@JsonProperty
	public Integer getQuality3Count() {
		return this.quality3Count;
	}
	
	@JsonProperty
	public Integer getQuality4Count() {
		return this.quality4Count;
	}
	
	@JsonProperty
	public Integer getQuality5Count() {
		return this.quality5Count;
	}
	
	@JsonProperty
	public Integer getReinforceCards() {
		return this.reinforceCards;
	}
	
	@JsonProperty
	public Integer getTodaysCards() {
		return this.todaysCards;
	}
	
	@JsonProperty
	public Integer getTotalCards() {
		return this.totalCards;
	}
	
}

/*       S.D.G.       */
