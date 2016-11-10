package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IPointsModel;
import com.anfelisa.user.models.ICredentialsModel;

@SuppressWarnings("unused")
public class PointsData implements IPointsModel, ICredentialsModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer points;
	
	@NotNull
	private String username;
	
	@NotNull
	private String role;
	


	public PointsData(
		@JsonProperty("points") Integer points,
		@JsonProperty("username") String username,
		@JsonProperty("role") String role
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.points = points;
		this.username = username;
		this.role = role;
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public Integer getPoints() {
		return this.points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
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
