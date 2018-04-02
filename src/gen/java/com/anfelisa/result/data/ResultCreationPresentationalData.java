package com.anfelisa.result.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.result.models.IResultModel;

@SuppressWarnings("all")
public class ResultCreationPresentationalData implements IResultCreationPresentationalData {
	
	@NotNull
	private String resultId;
	
	@NotNull
	private String username;
	
	@NotNull
	private String testId;
	
	@NotNull
	private org.joda.time.DateTime date;
	
	@NotNull
	private String json;
	
	@NotNull
	private Integer points;
	
	@NotNull
	private Integer maxPoints;
	
	
	public ResultCreationPresentationalData(
		@JsonProperty("resultId") String resultId,
		@JsonProperty("username") String username,
		@JsonProperty("testId") String testId,
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
	public String getResultId() {
		return this.resultId;
	}
	public void setResultId(String resultId) {
		this.resultId = resultId;
	}
	public ResultCreationPresentationalData withResultId(String resultId) {
		this.resultId = resultId;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ResultCreationPresentationalData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getTestId() {
		return this.testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public ResultCreationPresentationalData withTestId(String testId) {
		this.testId = testId;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getDate() {
		return this.date;
	}
	public void setDate(org.joda.time.DateTime date) {
		this.date = date;
	}
	public ResultCreationPresentationalData withDate(org.joda.time.DateTime date) {
		this.date = date;
		return this;
	}
	
	@JsonProperty
	public String getJson() {
		return this.json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public ResultCreationPresentationalData withJson(String json) {
		this.json = json;
		return this;
	}
	
	@JsonProperty
	public Integer getPoints() {
		return this.points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public ResultCreationPresentationalData withPoints(Integer points) {
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
	public ResultCreationPresentationalData withMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
		return this;
	}
	
}

/*       S.D.G.       */
