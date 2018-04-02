package com.anfelisa.lesson.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=LessonModel.class)
public interface ILessonModel {

	String getLessonId();
	String getName();
	String getDescription();
	Integer getSequence();
	String getCourseId();
	String getAuthor();

}

/*       S.D.G.       */
