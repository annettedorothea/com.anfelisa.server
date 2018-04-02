package com.anfelisa.course.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class StudentOfCourseModel implements IStudentOfCourseModel {

	@NotNull
	private String username;
	
	@NotNull
	private String courseId;
	

	public StudentOfCourseModel(
		@JsonProperty("username") String username,
		@JsonProperty("courseId") String courseId
	) {
		this.username = username;
		this.courseId = courseId;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public String getCourseId() {
		return this.courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	

}

/*       S.D.G.       */
