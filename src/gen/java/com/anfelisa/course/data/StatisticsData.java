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
public class StatisticsData implements IStatisticsData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
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
	

	private org.joda.time.DateTime systemTime;
	
	public StatisticsData(
		@JsonProperty("username") String username,
		@JsonProperty("year") Integer year,
		@JsonProperty("month") Integer month,
		@JsonProperty("points") Integer points,
		@JsonProperty("maxPoints") Integer maxPoints,
		@JsonProperty("rate") Integer rate,
		@JsonProperty("statisticsItemList") java.util.List<com.anfelisa.course.models.IStatisticsItemModel> statisticsItemList
,		@JsonProperty("uuid") String uuid
	) {
		this.username = username;
		this.year = year;
		this.month = month;
		this.points = points;
		this.maxPoints = maxPoints;
		this.rate = rate;
		this.statisticsItemList = statisticsItemList;
		this.uuid = uuid;
		
	}

	public StatisticsData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public StatisticsData withUsername(String username) {
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
	public StatisticsData withYear(Integer year) {
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
	public StatisticsData withMonth(Integer month) {
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
	public StatisticsData withPoints(Integer points) {
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
	public StatisticsData withMaxPoints(Integer maxPoints) {
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
	public StatisticsData withRate(Integer rate) {
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
	public StatisticsData withStatisticsItemList(java.util.List<com.anfelisa.course.models.IStatisticsItemModel> statisticsItemList) {
		this.statisticsItemList = statisticsItemList;
		return this;
	}
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public org.joda.time.DateTime getSystemTime() {
		return systemTime;
	}

	@JsonProperty
	public void setSystemTime(org.joda.time.DateTime systemTime) {
		this.systemTime = systemTime;
	}

	@JsonProperty
	public String getOutcome() {
		return outcome;
	}

	@JsonProperty
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	@Override
	@JsonProperty
	public String[] getNotifiedListeners() {
		return notifiedListeners;
	}

	@Override
	@JsonProperty
	public void setNotifiedListeners(String[] listeners) {
		this.notifiedListeners = listeners;
	}

	@Override
	public Object toPresentationalData() {
		return new StatisticsPresentationalData(
			this.username,
			this.year,
			this.month,
			this.points,
			this.maxPoints,
			this.rate,
			this.statisticsItemList
		);
	}

}

/*       S.D.G.       */
