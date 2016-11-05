package com.anfelisa.result.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

@SuppressWarnings("unused")
public class ResultModel implements IResultModel {

	@NotNull
	private Integer id;
	
	@NotNull
	private String username;
	
	@NotNull
	private Integer testId;
	
	@NotNull
	private DateTime date;
	
	@NotNull
	private String json;
	
	@NotNull
	private Integer points;
	
	@NotNull
	private Integer maxPoints;
	

	public ResultModel(
		@JsonProperty("id") Integer id,
		@JsonProperty("username") String username,
		@JsonProperty("testId") Integer testId,
		@JsonProperty("date") DateTime date,
		@JsonProperty("json") String json,
		@JsonProperty("points") Integer points,
		@JsonProperty("maxPoints") Integer maxPoints
	) {
		this.id = id;
		this.username = username;
		this.testId = testId;
		this.date = date;
		this.json = json;
		this.points = points;
		this.maxPoints = maxPoints;
	}

	@JsonProperty
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public Integer getTestId() {
		return this.testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	
	@JsonProperty
	public DateTime getDate() {
		return this.date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	
	@JsonProperty
	public String getJson() {
		return this.json;
	}
	public void setJson(String json) {
		this.json = json;
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
	

}

/*       S.D.G.       */
