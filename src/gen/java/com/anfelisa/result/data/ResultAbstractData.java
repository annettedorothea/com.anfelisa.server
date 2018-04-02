package com.anfelisa.result.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.result.models.IResultAbstractModel;

@SuppressWarnings("all")
public class ResultAbstractData implements IResultAbstractData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	@NotNull
	private String resultId;
	
	@NotNull
	private org.joda.time.DateTime date;
	
	@NotNull
	private Integer points;
	
	@NotNull
	private Integer maxPoints;
	

	private org.joda.time.DateTime systemTime;
	
	public ResultAbstractData(
		@JsonProperty("resultId") String resultId,
		@JsonProperty("date") org.joda.time.DateTime date,
		@JsonProperty("points") Integer points,
		@JsonProperty("maxPoints") Integer maxPoints
,		@JsonProperty("uuid") String uuid
	) {
		this.resultId = resultId;
		this.date = date;
		this.points = points;
		this.maxPoints = maxPoints;
		this.uuid = uuid;
		
	}

	public ResultAbstractData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getResultId() {
		return this.resultId;
	}
	public void setResultId(String resultId) {
		this.resultId = resultId;
	}
	public ResultAbstractData withResultId(String resultId) {
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
		return new ResultAbstractPresentationalData(
			this.resultId,
			this.date,
			this.points,
			this.maxPoints
		);
	}

}

/*       S.D.G.       */
