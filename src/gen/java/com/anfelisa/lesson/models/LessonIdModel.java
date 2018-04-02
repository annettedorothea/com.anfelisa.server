package com.anfelisa.lesson.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class LessonIdModel implements ILessonIdModel {

	@NotNull
	private String lessonId;
	

	public LessonIdModel(
		@JsonProperty("lessonId") String lessonId
	) {
		this.lessonId = lessonId;
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
