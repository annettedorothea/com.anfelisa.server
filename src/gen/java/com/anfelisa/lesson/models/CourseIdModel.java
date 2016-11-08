package com.anfelisa.lesson.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

@SuppressWarnings("unused")
public class CourseIdModel implements ICourseIdModel {

	@NotNull
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
