package com.anfelisa.result.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.result.models.IResultAbstractModel;

@SuppressWarnings("unused")
public class ResultAbstractData implements IResultAbstractModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer resultId;
	
	@NotNull
	private org.joda.time.DateTime date;
	
	@NotNull
	private Integer points;
	
	@NotNull
	private Integer maxPoints;
	

	

	public ResultAbstractData(
		@JsonProperty("resultId") Integer resultId,
		@JsonProperty("date") org.joda.time.DateTime date,
		@JsonProperty("points") Integer points,
		@JsonProperty("maxPoints") Integer maxPoints
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.resultId = resultId;
		this.date = date;
		this.points = points;
		this.maxPoints = maxPoints;
		this.uuid = uuid;
		this.schema = schema;
	}

	public ResultAbstractData(
		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
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
	public ResultAbstractData withResultId(Integer resultId) {
		this.resultId = resultId;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getDate() {
		return this.date;
	}
	public void setDate(org.joda.time.DateTime date) {
		this.date = date;
	}
	public ResultAbstractData withDate(org.joda.time.DateTime date) {
		this.date = date;
		return this;
	}
	
	@JsonProperty
	public Integer getPoints() {
		return this.points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public ResultAbstractData withPoints(Integer points) {
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
	public ResultAbstractData withMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
		return this;
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
