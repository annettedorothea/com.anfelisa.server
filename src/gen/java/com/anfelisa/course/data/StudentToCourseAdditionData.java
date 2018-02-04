package com.anfelisa.course.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.IStudentOfCourseModel;
import com.anfelisa.user.models.ICredentialsModel;

@SuppressWarnings("all")
public class StudentToCourseAdditionData implements IStudentToCourseAdditionData {
	
	private String uuid;
	
	private String outcome;
	
	private String createdId;
	
	@NotNull
	private String username;
	
	@NotNull
	private Integer courseId;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	

	
	
	private org.joda.time.DateTime systemTime;
	
	public StudentToCourseAdditionData(
		@JsonProperty("username") String username,
		@JsonProperty("courseId") Integer courseId,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
,		@JsonProperty("uuid") String uuid
	) {
		this.username = username;
		this.courseId = courseId;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.uuid = uuid;
	}

	public StudentToCourseAdditionData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public StudentToCourseAdditionData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public Integer getCourseId() {
		return this.courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public StudentToCourseAdditionData withCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public StudentToCourseAdditionData withCredentialsUsername(String credentialsUsername) {
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
	public StudentToCourseAdditionData withCredentialsRole(String credentialsRole) {
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
