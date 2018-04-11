package com.anfelisa.course.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class StatisticsItemModel implements IStatisticsItemModel {

	@NotNull
	private String type;
	
	@NotNull
	private Boolean isBox = false;
	
	@NotNull
	private Integer count;
	
	@NotNull
	private Integer day;
	
	@NotNull
	private String name;
	
	@NotNull
	private Integer points;
	
	@NotNull
	private Integer maxPoints;
	
	@NotNull
	private Integer rate;
	

	public StatisticsItemModel(
		@JsonProperty("type") String type,
		@JsonProperty("isBox") Boolean isBox,
		@JsonProperty("count") Integer count,
		@JsonProperty("day") Integer day,
		@JsonProperty("name") String name,
		@JsonProperty("points") Integer points,
		@JsonProperty("maxPoints") Integer maxPoints,
		@JsonProperty("rate") Integer rate
	) {
		this.type = type;
		this.isBox = isBox;
		this.count = count;
		this.day = day;
		this.name = name;
		this.points = points;
		this.maxPoints = maxPoints;
		this.rate = rate;
	}

	@JsonProperty
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@JsonProperty
	public Boolean getIsBox() {
		return this.isBox;
	}
	public void setIsBox(Boolean isBox) {
		this.isBox = isBox;
	}
	
	@JsonProperty
	public Integer getCount() {
		return this.count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	@JsonProperty
	public Integer getDay() {
		return this.day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Integer getRate() {
		return this.rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	

}

/*       S.D.G.       */
