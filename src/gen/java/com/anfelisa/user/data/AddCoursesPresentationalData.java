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
public class AddCoursesPresentationalData implements IAddCoursesPresentationalData {
	
	private java.util.List<String> courseIdList;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	
	public AddCoursesPresentationalData(
		@JsonProperty("courseIdList") java.util.List<String> courseIdList,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
	) {
		this.courseIdList = courseIdList;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		
	}

	@JsonProperty
	public java.util.List<String> getCourseIdList() {
		return this.courseIdList;
	}
	public void setCourseIdList(java.util.List<String> courseIdList) {
		this.courseIdList = courseIdList;
	}
	public AddCoursesPresentationalData withCourseIdList(java.util.List<String> courseIdList) {
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
	public AddCoursesPresentationalData withCredentialsUsername(String credentialsUsername) {
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
	public AddCoursesPresentationalData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
}

/*       S.D.G.       */
