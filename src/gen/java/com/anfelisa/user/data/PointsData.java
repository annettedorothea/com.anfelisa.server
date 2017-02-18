package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IPointsModel;
import com.anfelisa.user.models.IUsernameModel;

@SuppressWarnings("unused")
public class PointsData implements IPointsData {
	
	private String uuid;
	
	private String createdId;
	
	@NotNull
	private Integer points;
	
	@NotNull
	private String username;
	

	
	
	private org.joda.time.DateTime systemTime;
	
	public PointsData(
		@JsonProperty("points") Integer points,
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid
	) {
		this.points = points;
		this.username = username;
		this.uuid = uuid;
	}

	public PointsData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public Integer getPoints() {
		return this.points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public PointsData withPoints(Integer points) {
		this.points = points;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public PointsData withUsername(String username) {
		this.username = username;
		return this;
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
