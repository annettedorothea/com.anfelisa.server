package com.anfelisa.lesson.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class LessonIdModel implements ILessonIdModel {

	@NotNull
	private Integer lessonId;
	


	public LessonIdModel(
		@JsonProperty("lessonId") Integer lessonId
	) {
		this.lessonId = lessonId;
	}

	@JsonProperty
	public Integer getLessonId() {
		return this.lessonId;
	}
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}
	

		
}

/*       S.D.G.       */