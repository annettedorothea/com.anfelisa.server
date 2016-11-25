package com.anfelisa.course.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.IStatisticsModel;
import com.anfelisa.course.models.IStatisticsItemModel;

@SuppressWarnings("unused")
public class StatisticsData implements IStatisticsModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private String username;
	
	@NotNull
	private Integer year;
	
	@NotNull
	private Integer month;
	

	List<IStatisticsItemModel> StatisticsItemList;
	

	public StatisticsData(
		@JsonProperty("username") String username,
		@JsonProperty("year") Integer year,
		@JsonProperty("month") Integer month
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.username = username;
		this.year = year;
		this.month = month;
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public Integer getYear() {
		return this.year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	@JsonProperty
	public Integer getMonth() {
		return this.month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	
	@JsonProperty
	public List<IStatisticsItemModel> getStatisticsItemList() {
		return this.StatisticsItemList;
	}
	public void setStatisticsItemList(List<IStatisticsItemModel> StatisticsItemList) {
		this.StatisticsItemList = StatisticsItemList;
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
