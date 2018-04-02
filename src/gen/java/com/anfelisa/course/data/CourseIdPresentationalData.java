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
	private String courseId;
	
	
	public CourseIdPresentationalData(
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
	public CourseIdPresentationalData withCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
}

/*       S.D.G.       */
