package com.anfelisa.result.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ResultAbstractModel implements IResultAbstractModel {

	@NotNull
	private Integer resultId;
	
	@NotNull
	private org.joda.time.DateTime date;
	
	@NotNull
	private Integer points;
	
	@NotNull
	private Integer maxPoints;
	


	public ResultAbstractModel(
		@JsonProperty("resultId") Integer resultId,
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
	public Integer getResultId() {
		return this.resultId;
	}
	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getDate() {
		return this.date;
	}
	public void setDate(org.joda.time.DateTime date) {
		this.date = date;
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
