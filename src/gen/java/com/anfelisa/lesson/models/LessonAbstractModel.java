package com.anfelisa.lesson.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class LessonAbstractModel implements ILessonAbstractModel {

	@NotNull
	private String lessonName;
	
	private String lessonDescription;
	
	@NotNull
	private String lessonAuthor;
	
	@NotNull
	private String lessonId;
	

	public LessonAbstractModel(
		@JsonProperty("lessonName") String lessonName,
		@JsonProperty("lessonDescription") String lessonDescription,
		@JsonProperty("lessonAuthor") String lessonAuthor,
		@JsonProperty("lessonId") String lessonId
	) {
		this.lessonName = lessonName;
		this.lessonDescription = lessonDescription;
		this.lessonAuthor = lessonAuthor;
		this.lessonId = lessonId;
	}

	@JsonProperty
	public String getLessonName() {
		return this.lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	
	@JsonProperty
	public String getLessonDescription() {
		return this.lessonDescription;
	}
	public void setLessonDescription(String lessonDescription) {
		this.lessonDescription = lessonDescription;
	}
	
	@JsonProperty
	public String getLessonAuthor() {
		return this.lessonAuthor;
	}
	public void setLessonAuthor(String lessonAuthor) {
		this.lessonAuthor = lessonAuthor;
	}
	
	@JsonProperty
	public String getLessonId() {
		return this.lessonId;
	}
	public void setLessonId(String lessonId) {
		this.lessonId = lessonId;
	}
	

}

/*       S.D.G.       */
