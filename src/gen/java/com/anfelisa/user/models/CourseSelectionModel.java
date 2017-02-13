package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CourseSelectionModel implements ICourseSelectionModel {

	private java.util.List<Integer> courseIdList;
	


	public CourseSelectionModel(
		@JsonProperty("courseIdList") java.util.List<Integer> courseIdList
	) {
		this.courseIdList = courseIdList;
	}

	@JsonProperty
	public java.util.List<Integer> getCourseIdList() {
		return this.courseIdList;
	}
	public void setCourseIdList(java.util.List<Integer> courseIdList) {
		this.courseIdList = courseIdList;
	}
	

		
}

/*       S.D.G.       */
