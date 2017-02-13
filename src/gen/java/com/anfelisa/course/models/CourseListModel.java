package com.anfelisa.course.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CourseListModel implements ICourseListModel {


	private java.util.List<com.anfelisa.course.models.ICourseModel> courseList;
	

	public CourseListModel(
	) {
	}


	@JsonProperty
	public java.util.List<com.anfelisa.course.models.ICourseModel> getCourseList() {
		return this.courseList;
	}
	public void setCourseList(java.util.List<com.anfelisa.course.models.ICourseModel> courseList) {
		this.courseList = courseList;
	}
	
		
}

/*       S.D.G.       */
