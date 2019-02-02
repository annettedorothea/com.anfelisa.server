package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class BoxViewModel implements IBoxViewModel {

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
	

	public BoxViewModel() {
	}

	public BoxViewModel(
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
	
	
	public List<String> equalsPrimitiveTypes(IBoxViewModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getTodaysCards() == null && other.getTodaysCards() == null) && !this.getTodaysCards().equals(other.getTodaysCards())) {
			differingAttributes.add("todaysCards: " + this.getTodaysCards() + " " + other.getTodaysCards());
		}
		if (!(this.getTotalCards() == null && other.getTotalCards() == null) && !this.getTotalCards().equals(other.getTotalCards())) {
			differingAttributes.add("totalCards: " + this.getTotalCards() + " " + other.getTotalCards());
		}
		if (!(this.getReinforceCards() == null && other.getReinforceCards() == null) && !this.getReinforceCards().equals(other.getReinforceCards())) {
			differingAttributes.add("reinforceCards: " + this.getReinforceCards() + " " + other.getReinforceCards());
		}
		if (!(this.getMyCards() == null && other.getMyCards() == null) && !this.getMyCards().equals(other.getMyCards())) {
			differingAttributes.add("myCards: " + this.getMyCards() + " " + other.getMyCards());
		}
		if (!(this.getDaysBehindSchedule() == null && other.getDaysBehindSchedule() == null) && !this.getDaysBehindSchedule().equals(other.getDaysBehindSchedule())) {
			differingAttributes.add("daysBehindSchedule: " + this.getDaysBehindSchedule() + " " + other.getDaysBehindSchedule());
		}
		if (!(this.getCategoryName() == null && other.getCategoryName() == null) && !this.getCategoryName().equals(other.getCategoryName())) {
			differingAttributes.add("categoryName: " + this.getCategoryName() + " " + other.getCategoryName());
		}
		if (!(this.getMaxInterval() == null && other.getMaxInterval() == null) && !this.getMaxInterval().equals(other.getMaxInterval())) {
			differingAttributes.add("maxInterval: " + this.getMaxInterval() + " " + other.getMaxInterval());
		}
		if (!(this.getMaxCardsPerDay() == null && other.getMaxCardsPerDay() == null) && !this.getMaxCardsPerDay().equals(other.getMaxCardsPerDay())) {
			differingAttributes.add("maxCardsPerDay: " + this.getMaxCardsPerDay() + " " + other.getMaxCardsPerDay());
		}
		if (!(this.getQuality0Count() == null && other.getQuality0Count() == null) && !this.getQuality0Count().equals(other.getQuality0Count())) {
			differingAttributes.add("quality0Count: " + this.getQuality0Count() + " " + other.getQuality0Count());
		}
		if (!(this.getQuality1Count() == null && other.getQuality1Count() == null) && !this.getQuality1Count().equals(other.getQuality1Count())) {
			differingAttributes.add("quality1Count: " + this.getQuality1Count() + " " + other.getQuality1Count());
		}
		if (!(this.getQuality2Count() == null && other.getQuality2Count() == null) && !this.getQuality2Count().equals(other.getQuality2Count())) {
			differingAttributes.add("quality2Count: " + this.getQuality2Count() + " " + other.getQuality2Count());
		}
		if (!(this.getQuality3Count() == null && other.getQuality3Count() == null) && !this.getQuality3Count().equals(other.getQuality3Count())) {
			differingAttributes.add("quality3Count: " + this.getQuality3Count() + " " + other.getQuality3Count());
		}
		if (!(this.getQuality4Count() == null && other.getQuality4Count() == null) && !this.getQuality4Count().equals(other.getQuality4Count())) {
			differingAttributes.add("quality4Count: " + this.getQuality4Count() + " " + other.getQuality4Count());
		}
		if (!(this.getQuality5Count() == null && other.getQuality5Count() == null) && !this.getQuality5Count().equals(other.getQuality5Count())) {
			differingAttributes.add("quality5Count: " + this.getQuality5Count() + " " + other.getQuality5Count());
		}
		if (!(this.getBoxId() == null && other.getBoxId() == null) && !this.getBoxId().equals(other.getBoxId())) {
			differingAttributes.add("boxId: " + this.getBoxId() + " " + other.getBoxId());
		}
		return differingAttributes;
	}
	
}

/*       S.D.G.       */
