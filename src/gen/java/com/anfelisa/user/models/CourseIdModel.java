package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CourseIdModel implements ICourseIdModel {

	private Integer courseId;
	

	public CourseIdModel(
		@JsonProperty("courseId") Integer courseId
	) {
		this.courseId = courseId;
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
