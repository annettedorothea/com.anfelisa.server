package com.anfelisa.lesson.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class MyLessonListModel implements IMyLessonListModel {


	private java.util.List<com.anfelisa.lesson.models.IMyLessonModel> myLessonList;
	

	public MyLessonListModel(
	) {
	}


	@JsonProperty
	public java.util.List<com.anfelisa.lesson.models.IMyLessonModel> getMyLessonList() {
		return this.myLessonList;
	}
	public void setMyLessonList(java.util.List<com.anfelisa.lesson.models.IMyLessonModel> myLessonList) {
		this.myLessonList = myLessonList;
	}
	
		
}

/*       S.D.G.       */
