package com.anfelisa.lesson.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.lesson.models.ILessonModel;

@SuppressWarnings("all")
public class LessonCreationPresentationalData implements ILessonCreationPresentationalData {
	
	@NotNull
	private String lessonId;
	
	@NotNull
	private String name;
	
	private String description;
	
	private Integer sequence;
	
	@NotNull
	private String courseId;
	
	@NotNull
	private String author;
	
	
	public LessonCreationPresentationalData(
		@JsonProperty("lessonId") String lessonId,
		@JsonProperty("name") String name,
		@JsonProperty("description") String description,
		@JsonProperty("sequence") Integer sequence,
		@JsonProperty("courseId") String courseId,
		@JsonProperty("author") String author
	) {
		this.lessonId = lessonId;
		this.name = name;
		this.description = description;
		this.sequence = sequence;
		this.courseId = courseId;
		this.author = author;
		
	}

	@JsonProperty
	public String getLessonId() {
		return this.lessonId;
	}
	public void setLessonId(String lessonId) {
		this.lessonId = lessonId;
	}
	public LessonCreationPresentationalData withLessonId(String lessonId) {
		this.lessonId = lessonId;
		return this;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LessonCreationPresentationalData withName(String name) {
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
	public LessonCreationPresentationalData withDescription(String description) {
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
	public LessonCreationPresentationalData withSequence(Integer sequence) {
		this.sequence = sequence;
		return this;
	}
	
	@JsonProperty
	public String getCourseId() {
		return this.courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public LessonCreationPresentationalData withCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	@JsonProperty
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LessonCreationPresentationalData withAuthor(String author) {
		this.author = author;
		return this;
	}
	
}

/*       S.D.G.       */
