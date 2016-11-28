package com.anfelisa.course.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class StudentOfCourseModel implements IStudentOfCourseModel {

	@NotNull
	private String username;
	
	@NotNull
	private Integer courseId;
	


	public StudentOfCourseModel(
		@JsonProperty("username") String username,
		@JsonProperty("courseId") Integer courseId
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
	public Integer getCourseId() {
		return this.courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	


}

/*       S.D.G.       */
