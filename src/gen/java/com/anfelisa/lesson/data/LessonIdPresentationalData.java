package com.anfelisa.lesson.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.lesson.models.ILessonIdModel;

@SuppressWarnings("all")
public class LessonIdPresentationalData implements ILessonIdPresentationalData {
	
	@NotNull
	private Integer lessonId;
	
	
	public LessonIdPresentationalData(
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
	public LessonIdPresentationalData withLessonId(Integer lessonId) {
		this.lessonId = lessonId;
		return this;
	}
	
}

/*       S.D.G.       */
