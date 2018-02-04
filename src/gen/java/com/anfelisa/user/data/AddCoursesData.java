package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ICourseSelectionModel;
import com.anfelisa.user.models.ICredentialsModel;

@SuppressWarnings("all")
public class AddCoursesData implements IAddCoursesData {
	
	private String uuid;
	
	private String outcome;
	
	private String createdId;
	
	private java.util.List<Integer> courseIdList;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	

	
	
	private org.joda.time.DateTime systemTime;
	
	public AddCoursesData(
		@JsonProperty("courseIdList") java.util.List<Integer> courseIdList,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
,		@JsonProperty("uuid") String uuid
	) {
		this.courseIdList = courseIdList;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.uuid = uuid;
	}

	public AddCoursesData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public java.util.List<Integer> getCourseIdList() {
		return this.courseIdList;
	}
	public void setCourseIdList(java.util.List<Integer> courseIdList) {
		this.courseIdList = courseIdList;
	}
	public AddCoursesData withCourseIdList(java.util.List<Integer> courseIdList) {
		this.courseIdList = courseIdList;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public AddCoursesData withCredentialsUsername(String credentialsUsername) {
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
	public AddCoursesData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
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

	@JsonProperty
	public String getOutcome() {
		return outcome;
	}

	@JsonProperty
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

}

/*       S.D.G.       */
