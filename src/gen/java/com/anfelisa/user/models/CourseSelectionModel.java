package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CourseSelectionModel implements ICourseSelectionModel {

	private String language;
	
	private java.util.List<Integer> courseIdList;
	


	public CourseSelectionModel(
		@JsonProperty("language") String language,
		@JsonProperty("courseIdList") java.util.List<Integer> courseIdList
	) {
		this.language = language;
		this.courseIdList = courseIdList;
	}

	@JsonProperty
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
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
