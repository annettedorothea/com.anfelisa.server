package com.anfelisa.result.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ResultModel implements IResultModel {

	@NotNull
	private Integer resultId;
	
	@NotNull
	private String username;
	
	@NotNull
	private Integer testId;
	
	@NotNull
	private org.joda.time.DateTime date;
	
	@NotNull
	private String json;
	
	@NotNull
	private Integer points;
	
	@NotNull
	private Integer maxPoints;
	


	public ResultModel(
		@JsonProperty("resultId") Integer resultId,
		@JsonProperty("username") String username,
		@JsonProperty("testId") Integer testId,
		@JsonProperty("date") org.joda.time.DateTime date,
		@JsonProperty("json") String json,
		@JsonProperty("points") Integer points,
		@JsonProperty("maxPoints") Integer maxPoints
	) {
		this.resultId = resultId;
		this.username = username;
		this.testId = testId;
		this.date = date;
		this.json = json;
		this.points = points;
		this.maxPoints = maxPoints;
	}

	@JsonProperty
	public Integer getResultId() {
		return this.resultId;
	}
	public void setResultId(Integer resultId) {
		this.resultId = resultId;
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
	public org.joda.time.DateTime getDate() {
		return this.date;
	}
	public void setDate(org.joda.time.DateTime date) {
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
