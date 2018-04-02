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
public class ResultAbstractPresentationalData implements IResultAbstractPresentationalData {
	
	@NotNull
	private String resultId;
	
	@NotNull
	private org.joda.time.DateTime date;
	
	@NotNull
	private Integer points;
	
	@NotNull
	private Integer maxPoints;
	
	
	public ResultAbstractPresentationalData(
		@JsonProperty("resultId") String resultId,
		@JsonProperty("date") org.joda.time.DateTime date,
		@JsonProperty("points") Integer points,
		@JsonProperty("maxPoints") Integer maxPoints
	) {
		this.resultId = resultId;
		this.date = date;
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
	public ResultAbstractPresentationalData withResultId(String resultId) {
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
	public ResultAbstractPresentationalData withDate(org.joda.time.DateTime date) {
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
	public ResultAbstractPresentationalData withPoints(Integer points) {
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
	public ResultAbstractPresentationalData withMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
		return this;
	}
	
}

/*       S.D.G.       */
