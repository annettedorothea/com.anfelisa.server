package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CourseSelectionModel implements ICourseSelectionModel {

	private java.util.List<String> courseIdList;
	

	public CourseSelectionModel(
		@JsonProperty("courseIdList") java.util.List<String> courseIdList
	) {
		this.courseIdList = courseIdList;
	}

	@JsonProperty
	public java.util.List<String> getCourseIdList() {
		return this.courseIdList;
	}
	public void setCourseIdList(java.util.List<String> courseIdList) {
		this.courseIdList = courseIdList;
	}
	

}

/*       S.D.G.       */
