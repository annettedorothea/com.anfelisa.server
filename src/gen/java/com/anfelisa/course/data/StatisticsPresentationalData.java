package com.anfelisa.course.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.IStatisticsModel;
import com.anfelisa.course.models.IStatisticsItemListModel;

@SuppressWarnings("all")
public class StatisticsPresentationalData implements IStatisticsPresentationalData {
	
	@NotNull
	private String username;
	
	@NotNull
	private Integer year;
	
	@NotNull
	private Integer month;
	
	@NotNull
	private Integer points;
	
	@NotNull
	private Integer maxPoints;
	
	@NotNull
	private Integer rate;
	
	private java.util.List<com.anfelisa.course.models.IStatisticsItemModel> statisticsItemList;
	
	
	public StatisticsPresentationalData(
		@JsonProperty("username") String username,
		@JsonProperty("year") Integer year,
		@JsonProperty("month") Integer month,
		@JsonProperty("points") Integer points,
		@JsonProperty("maxPoints") Integer maxPoints,
		@JsonProperty("rate") Integer rate,
		@JsonProperty("statisticsItemList") java.util.List<com.anfelisa.course.models.IStatisticsItemModel> statisticsItemList
	) {
		this.username = username;
		this.year = year;
		this.month = month;
		this.points = points;
		this.maxPoints = maxPoints;
		this.rate = rate;
		this.statisticsItemList = statisticsItemList;
		
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public StatisticsPresentationalData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public Integer getYear() {
		return this.year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public StatisticsPresentationalData withYear(Integer year) {
		this.year = year;
		return this;
	}
	
	@JsonProperty
	public Integer getMonth() {
		return this.month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public StatisticsPresentationalData withMonth(Integer month) {
		this.month = month;
		return this;
	}
	
	@JsonProperty
	public Integer getPoints() {
		return this.points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public StatisticsPresentationalData withPoints(Integer points) {
		this.points = points;
		return this;
	}
	
	@JsonProperty
	public Integer getMaxPoints() {
		return this.maxPoints;
	}
	public void setMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
	}
	public StatisticsPresentationalData withMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
		return this;
	}
	
	@JsonProperty
	public Integer getRate() {
		return this.rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public StatisticsPresentationalData withRate(Integer rate) {
		this.rate = rate;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.course.models.IStatisticsItemModel> getStatisticsItemList() {
		return this.statisticsItemList;
	}
	public void setStatisticsItemList(java.util.List<com.anfelisa.course.models.IStatisticsItemModel> statisticsItemList) {
		this.statisticsItemList = statisticsItemList;
	}
	public StatisticsPresentationalData withStatisticsItemList(java.util.List<com.anfelisa.course.models.IStatisticsItemModel> statisticsItemList) {
		this.statisticsItemList = statisticsItemList;
		return this;
	}
	
}

/*       S.D.G.       */
