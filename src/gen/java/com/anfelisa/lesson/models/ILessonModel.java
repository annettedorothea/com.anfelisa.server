package com.anfelisa.lesson.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=LessonModel.class)
public interface ILessonModel {

	Integer getLessonId();
	String getName();
	String getDescription();
	Integer getSequence();
	Integer getCourseId();
	String getAuthor();


}

/*       S.D.G.       */
