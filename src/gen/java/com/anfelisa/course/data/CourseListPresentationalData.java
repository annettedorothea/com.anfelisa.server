package com.anfelisa.course.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.ICourseListModel;

@SuppressWarnings("all")
public class CourseListPresentationalData implements ICourseListPresentationalData {
	
	private java.util.List<com.anfelisa.course.models.ICourseModel> courseList;
	
	
	public CourseListPresentationalData(
		@JsonProperty("courseList") java.util.List<com.anfelisa.course.models.ICourseModel> courseList
	) {
		this.courseList = courseList;
		
	}

	@JsonProperty
	public java.util.List<com.anfelisa.course.models.ICourseModel> getCourseList() {
		return this.courseList;
	}
	public void setCourseList(java.util.List<com.anfelisa.course.models.ICourseModel> courseList) {
		this.courseList = courseList;
	}
	public CourseListPresentationalData withCourseList(java.util.List<com.anfelisa.course.models.ICourseModel> courseList) {
		this.courseList = courseList;
		return this;
	}
	
}

/*       S.D.G.       */
