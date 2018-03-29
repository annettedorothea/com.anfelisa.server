package com.anfelisa.course.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.ICourseIdModel;

@SuppressWarnings("all")
public class CourseIdPresentationalData implements ICourseIdPresentationalData {
	
	@NotNull
	private Integer courseId;
	
	
	public CourseIdPresentationalData(
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
	public CourseIdPresentationalData withCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
}

/*       S.D.G.       */
