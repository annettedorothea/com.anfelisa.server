package com.anfelisa.course.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.ICourseModel;

@SuppressWarnings("all")
public class CourseCreationPresentationalData implements ICourseCreationPresentationalData {
	
	@NotNull
	private String courseId;
	
	@NotNull
	private String name;
	
	private String description;
	
	private Integer sequence;
	
	@NotNull
	private String author;
	
	
	public CourseCreationPresentationalData(
		@JsonProperty("courseId") String courseId,
		@JsonProperty("name") String name,
		@JsonProperty("description") String description,
		@JsonProperty("sequence") Integer sequence,
		@JsonProperty("author") String author
	) {
		this.courseId = courseId;
		this.name = name;
		this.description = description;
		this.sequence = sequence;
		this.author = author;
		
	}

	@JsonProperty
	public String getCourseId() {
		return this.courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public CourseCreationPresentationalData withCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CourseCreationPresentationalData withName(String name) {
		this.name = name;
		return this;
	}
	
	@JsonProperty
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CourseCreationPresentationalData withDescription(String description) {
		this.description = description;
		return this;
	}
	
	@JsonProperty
	public Integer getSequence() {
		return this.sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public CourseCreationPresentationalData withSequence(Integer sequence) {
		this.sequence = sequence;
		return this;
	}
	
	@JsonProperty
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public CourseCreationPresentationalData withAuthor(String author) {
		this.author = author;
		return this;
	}
	
}

/*       S.D.G.       */
