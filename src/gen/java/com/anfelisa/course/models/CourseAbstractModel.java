package com.anfelisa.course.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CourseAbstractModel implements ICourseAbstractModel {

	@NotNull
	private String courseName;
	
	private String courseDescription;
	
	@NotNull
	private String courseAuthor;
	
	@NotNull
	private String courseId;
	

	public CourseAbstractModel(
		@JsonProperty("courseName") String courseName,
		@JsonProperty("courseDescription") String courseDescription,
		@JsonProperty("courseAuthor") String courseAuthor,
		@JsonProperty("courseId") String courseId
	) {
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseAuthor = courseAuthor;
		this.courseId = courseId;
	}

	@JsonProperty
	public String getCourseName() {
		return this.courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	@JsonProperty
	public String getCourseDescription() {
		return this.courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	@JsonProperty
	public String getCourseAuthor() {
		return this.courseAuthor;
	}
	public void setCourseAuthor(String courseAuthor) {
		this.courseAuthor = courseAuthor;
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
