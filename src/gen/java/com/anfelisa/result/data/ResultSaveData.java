package com.anfelisa.result.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.result.models.IResultModel;
import com.anfelisa.box.models.IFillBoxModel;
import com.anfelisa.user.models.ICredentialsModel;

@SuppressWarnings("all")
public class ResultSaveData implements IResultSaveData {
	
	private String uuid;
	
	private String createdId;
	
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
	
	private Integer boxId;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	private Boolean credentialsPremium;
	

	
	private java.util.List<com.anfelisa.box.models.IScheduledCardModel> cardsToBeAdded;
	
	
	private org.joda.time.DateTime systemTime;
	
	public ResultSaveData(
		@JsonProperty("resultId") Integer resultId,
		@JsonProperty("username") String username,
		@JsonProperty("testId") Integer testId,
		@JsonProperty("date") org.joda.time.DateTime date,
		@JsonProperty("json") String json,
		@JsonProperty("points") Integer points,
		@JsonProperty("maxPoints") Integer maxPoints,
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole,
		@JsonProperty("credentialsPremium") Boolean credentialsPremium
,		@JsonProperty("uuid") String uuid
	) {
		this.resultId = resultId;
		this.username = username;
		this.testId = testId;
		this.date = date;
		this.json = json;
		this.points = points;
		this.maxPoints = maxPoints;
		this.boxId = boxId;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.credentialsPremium = credentialsPremium;
		this.uuid = uuid;
	}

	public ResultSaveData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public Integer getResultId() {
		return this.resultId;
	}
	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}
	public ResultSaveData withResultId(Integer resultId) {
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
	public ResultSaveData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public Integer getTestId() {
		return this.testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public ResultSaveData withTestId(Integer testId) {
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
	public ResultSaveData withDate(org.joda.time.DateTime date) {
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
	public ResultSaveData withJson(String json) {
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
	public ResultSaveData withPoints(Integer points) {
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
	public ResultSaveData withMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
		return this;
	}
	
	@JsonProperty
	public Integer getBoxId() {
		return this.boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	public ResultSaveData withBoxId(Integer boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public ResultSaveData withCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsRole() {
		return this.credentialsRole;
	}
	public void setCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
	}
	public ResultSaveData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
	@JsonProperty
	public Boolean getCredentialsPremium() {
		return this.credentialsPremium;
	}
	public void setCredentialsPremium(Boolean credentialsPremium) {
		this.credentialsPremium = credentialsPremium;
	}
	public ResultSaveData withCredentialsPremium(Boolean credentialsPremium) {
		this.credentialsPremium = credentialsPremium;
		return this;
	}
	
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IScheduledCardModel> getCardsToBeAdded() {
		return this.cardsToBeAdded;
	}
	public void setCardsToBeAdded(java.util.List<com.anfelisa.box.models.IScheduledCardModel> cardsToBeAdded) {
		this.cardsToBeAdded = cardsToBeAdded;
	}
	
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonIgnore
	public String getCreatedId() {
		return createdId;
	}

	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

	@JsonProperty
	public org.joda.time.DateTime getSystemTime() {
		return systemTime;
	}

	@JsonProperty
	public void setSystemTime(org.joda.time.DateTime systemTime) {
		this.systemTime = systemTime;
	}

}

/*       S.D.G.       */
