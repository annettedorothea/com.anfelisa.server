package com.anfelisa.course.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class StatisticsModel implements IStatisticsModel {

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
	


	public StatisticsModel(
		@JsonProperty("username") String username,
		@JsonProperty("year") Integer year,
		@JsonProperty("month") Integer month,
		@JsonProperty("points") Integer points,
		@JsonProperty("maxPoints") Integer maxPoints,
		@JsonProperty("rate") Integer rate
	) {
		this.username = username;
		this.year = year;
		this.month = month;
		this.points = points;
		this.maxPoints = maxPoints;
		this.rate = rate;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public Integer getYear() {
		return this.year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	@JsonProperty
	public Integer getMonth() {
		return this.month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	
	@JsonProperty
	public Integer getPoints() {
		return this.points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	@JsonProperty
	public Integer getMaxPoints() {
		return this.maxPoints;
	}
	public void setMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
	}
	
	@JsonProperty
	public Integer getRate() {
		return this.rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	


}

/*       S.D.G.       */
