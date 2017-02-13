package com.anfelisa.lesson.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class LessonListModel implements ILessonListModel {


	private java.util.List<com.anfelisa.lesson.models.ILessonModel> lessonList;
	

	public LessonListModel(
	) {
	}


	@JsonProperty
	public java.util.List<com.anfelisa.lesson.models.ILessonModel> getLessonList() {
		return this.lessonList;
	}
	public void setLessonList(java.util.List<com.anfelisa.lesson.models.ILessonModel> lessonList) {
		this.lessonList = lessonList;
	}
	
		
}

/*       S.D.G.       */
