package com.anfelisa.result.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.result.models.IResultModel;
import com.anfelisa.box.models.IBoxIdListModel;

@SuppressWarnings("unused")
public class ResultSaveData implements IResultSaveData {
	
	private String uuid;
	
	private String schema;
	
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
	
	private java.util.List<Integer> boxIds;
	
	private java.util.List<Integer> numberOfInsertedCards;
	
	private java.util.List<String> boxNames;
	

	
	private java.util.List<com.anfelisa.box.models.ICardOfBoxModel> cardsToBeAdded;
	

	public ResultSaveData(
		@JsonProperty("resultId") Integer resultId,
		@JsonProperty("username") String username,
		@JsonProperty("testId") Integer testId,
		@JsonProperty("date") org.joda.time.DateTime date,
		@JsonProperty("json") String json,
		@JsonProperty("points") Integer points,
		@JsonProperty("maxPoints") Integer maxPoints,
		@JsonProperty("boxIds") java.util.List<Integer> boxIds,
		@JsonProperty("numberOfInsertedCards") java.util.List<Integer> numberOfInsertedCards,
		@JsonProperty("boxNames") java.util.List<String> boxNames
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.resultId = resultId;
		this.username = username;
		this.testId = testId;
		this.date = date;
		this.json = json;
		this.points = points;
		this.maxPoints = maxPoints;
		this.boxIds = boxIds;
		this.numberOfInsertedCards = numberOfInsertedCards;
		this.boxNames = boxNames;
		this.uuid = uuid;
		this.schema = schema;
	}

	public ResultSaveData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
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
	public java.util.List<Integer> getBoxIds() {
		return this.boxIds;
	}
	public void setBoxIds(java.util.List<Integer> boxIds) {
		this.boxIds = boxIds;
	}
	public ResultSaveData withBoxIds(java.util.List<Integer> boxIds) {
		this.boxIds = boxIds;
		return this;
	}
	
	@JsonProperty
	public java.util.List<Integer> getNumberOfInsertedCards() {
		return this.numberOfInsertedCards;
	}
	public void setNumberOfInsertedCards(java.util.List<Integer> numberOfInsertedCards) {
		this.numberOfInsertedCards = numberOfInsertedCards;
	}
	public ResultSaveData withNumberOfInsertedCards(java.util.List<Integer> numberOfInsertedCards) {
		this.numberOfInsertedCards = numberOfInsertedCards;
		return this;
	}
	
	@JsonProperty
	public java.util.List<String> getBoxNames() {
		return this.boxNames;
	}
	public void setBoxNames(java.util.List<String> boxNames) {
		this.boxNames = boxNames;
	}
	public ResultSaveData withBoxNames(java.util.List<String> boxNames) {
		this.boxNames = boxNames;
		return this;
	}
	
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.ICardOfBoxModel> getCardsToBeAdded() {
		return this.cardsToBeAdded;
	}
	public void setCardsToBeAdded(java.util.List<com.anfelisa.box.models.ICardOfBoxModel> cardsToBeAdded) {
		this.cardsToBeAdded = cardsToBeAdded;
	}
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}

}

/*       S.D.G.       */
