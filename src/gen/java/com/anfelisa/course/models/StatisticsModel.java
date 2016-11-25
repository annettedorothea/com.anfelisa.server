package com.anfelisa.course.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

@SuppressWarnings("unused")
public class StatisticsModel implements IStatisticsModel {

	@NotNull
	private String username;
	
	@NotNull
	private Integer year;
	
	@NotNull
	private Integer month;
	

	public StatisticsModel(
		@JsonProperty("username") String username,
		@JsonProperty("year") Integer year,
		@JsonProperty("month") Integer month
	) {
		this.username = username;
		this.year = year;
		this.month = month;
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
	

}

/*       S.D.G.       */
