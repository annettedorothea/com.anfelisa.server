package com.anfelisa.result.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ResultSaveModel implements IResultSaveModel {

	@NotNull
	private String username;
	
	@NotNull
	private Integer testId;
	
	@NotNull
	private String json;
	
	@NotNull
	private Integer points;
	
	@NotNull
	private Integer maxPoints;
	
	private org.joda.time.DateTime date;
	
	private String password;
	
	private String language;
	


	public ResultSaveModel(
		@JsonProperty("username") String username,
		@JsonProperty("testId") Integer testId,
		@JsonProperty("json") String json,
		@JsonProperty("points") Integer points,
		@JsonProperty("maxPoints") Integer maxPoints,
		@JsonProperty("date") org.joda.time.DateTime date,
		@JsonProperty("password") String password,
		@JsonProperty("language") String language
	) {
		this.username = username;
		this.testId = testId;
		this.json = json;
		this.points = points;
		this.maxPoints = maxPoints;
		this.date = date;
		this.password = password;
		this.language = language;
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
	
	@JsonProperty
	public org.joda.time.DateTime getDate() {
		return this.date;
	}
	public void setDate(org.joda.time.DateTime date) {
		this.date = date;
	}
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonProperty
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	


}

/*       S.D.G.       */
