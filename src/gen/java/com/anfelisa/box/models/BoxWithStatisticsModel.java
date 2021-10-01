/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class BoxWithStatisticsModel implements IBoxWithStatisticsModel {

	private Integer openTodaysCards;

	private String categoryName;

	private String categoryAuthor;

	private String categoryId;

	private String boxId;

	private Boolean reverse = false;

	private Boolean editable = false;

	private Boolean archived = false;

	private Integer quality0Count;

	private Integer quality1Count;

	private Integer quality2Count;

	private Integer quality3Count;

	private Integer quality4Count;

	private Integer quality5Count;

	private java.util.List<Integer> countsPerDayNextWeek;

	private Integer maxCardsPerDay;


	public BoxWithStatisticsModel() {
	}

	public BoxWithStatisticsModel(
		@JsonProperty("openTodaysCards") Integer openTodaysCards,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryAuthor") String categoryAuthor,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("reverse") Boolean reverse,
		@JsonProperty("editable") Boolean editable,
		@JsonProperty("archived") Boolean archived,
		@JsonProperty("quality0Count") Integer quality0Count,
		@JsonProperty("quality1Count") Integer quality1Count,
		@JsonProperty("quality2Count") Integer quality2Count,
		@JsonProperty("quality3Count") Integer quality3Count,
		@JsonProperty("quality4Count") Integer quality4Count,
		@JsonProperty("quality5Count") Integer quality5Count,
		@JsonProperty("countsPerDayNextWeek") java.util.List<Integer> countsPerDayNextWeek,
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay
	) {
		this.openTodaysCards = openTodaysCards;
		this.categoryName = categoryName;
		this.categoryAuthor = categoryAuthor;
		this.categoryId = categoryId;
		this.boxId = boxId;
		this.reverse = reverse;
		this.editable = editable;
		this.archived = archived;
		this.quality0Count = quality0Count;
		this.quality1Count = quality1Count;
		this.quality2Count = quality2Count;
		this.quality3Count = quality3Count;
		this.quality4Count = quality4Count;
		this.quality5Count = quality5Count;
		this.countsPerDayNextWeek = countsPerDayNextWeek;
		this.maxCardsPerDay = maxCardsPerDay;
	}

	@JsonProperty
	public Integer getOpenTodaysCards() {
		return this.openTodaysCards;
	}
	public void setOpenTodaysCards(Integer openTodaysCards) {
		this.openTodaysCards = openTodaysCards;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@JsonProperty
	public String getCategoryAuthor() {
		return this.categoryAuthor;
	}
	public void setCategoryAuthor(String categoryAuthor) {
		this.categoryAuthor = categoryAuthor;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
	public Boolean getReverse() {
		return this.reverse;
	}
	public void setReverse(Boolean reverse) {
		this.reverse = reverse;
	}
	
	@JsonProperty
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	
	@JsonProperty
	public Boolean getArchived() {
		return this.archived;
	}
	public void setArchived(Boolean archived) {
		this.archived = archived;
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
	public java.util.List<Integer> getCountsPerDayNextWeek() {
		return this.countsPerDayNextWeek;
	}
	public void setCountsPerDayNextWeek(java.util.List<Integer> countsPerDayNextWeek) {
		this.countsPerDayNextWeek = countsPerDayNextWeek;
	}
	
	@JsonProperty
	public Integer getMaxCardsPerDay() {
		return this.maxCardsPerDay;
	}
	public void setMaxCardsPerDay(Integer maxCardsPerDay) {
		this.maxCardsPerDay = maxCardsPerDay;
	}
	

	public IBoxWithStatisticsModel deepCopy() {
		IBoxWithStatisticsModel copy = new BoxWithStatisticsModel();
		copy.setOpenTodaysCards(this.getOpenTodaysCards());
		copy.setCategoryName(this.getCategoryName());
		copy.setCategoryAuthor(this.getCategoryAuthor());
		copy.setCategoryId(this.getCategoryId());
		copy.setBoxId(this.getBoxId());
		copy.setReverse(this.getReverse());
		copy.setEditable(this.getEditable());
		copy.setArchived(this.getArchived());
		copy.setQuality0Count(this.getQuality0Count());
		copy.setQuality1Count(this.getQuality1Count());
		copy.setQuality2Count(this.getQuality2Count());
		copy.setQuality3Count(this.getQuality3Count());
		copy.setQuality4Count(this.getQuality4Count());
		copy.setQuality5Count(this.getQuality5Count());
		List<Integer> countsPerDayNextWeekCopy = new ArrayList<Integer>();
		for(Integer item: this.getCountsPerDayNextWeek()) {
			countsPerDayNextWeekCopy.add(item);
		}
		copy.setCountsPerDayNextWeek(countsPerDayNextWeekCopy);
		copy.setMaxCardsPerDay(this.getMaxCardsPerDay());
		return copy;
	}

}



/******* S.D.G. *******/



