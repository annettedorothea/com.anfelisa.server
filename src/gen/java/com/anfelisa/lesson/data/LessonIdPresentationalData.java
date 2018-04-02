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
	private String lessonId;
	
	
	public LessonIdPresentationalData(
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
	public LessonIdPresentationalData withLessonId(String lessonId) {
		this.lessonId = lessonId;
		return this;
	}
	
}

/*       S.D.G.       */
