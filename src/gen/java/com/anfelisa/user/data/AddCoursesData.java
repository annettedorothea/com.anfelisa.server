package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ICourseSelectionModel;
import com.anfelisa.user.models.IUsernameModel;

@SuppressWarnings("unused")
public class AddCoursesData implements IAddCoursesData {
	
	private String uuid;
	
	private String schema;
	
	private java.util.List<Integer> courseIdList;
	
	@NotNull
	private String username;
	

	
	

	public AddCoursesData(
		@JsonProperty("courseIdList") java.util.List<Integer> courseIdList,
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.courseIdList = courseIdList;
		this.username = username;
		this.uuid = uuid;
		this.schema = schema;
	}

	public AddCoursesData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
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
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public AddCoursesData withUsername(String username) {
		this.username = username;
		return this;
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
