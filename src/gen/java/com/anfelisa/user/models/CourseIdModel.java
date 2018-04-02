package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CourseIdModel implements ICourseIdModel {

	private String courseId;
	

	public CourseIdModel(
		@JsonProperty("courseId") String courseId
	) {
		this.courseId = courseId;
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
