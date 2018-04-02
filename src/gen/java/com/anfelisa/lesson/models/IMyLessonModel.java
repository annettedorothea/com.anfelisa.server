package com.anfelisa.lesson.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=MyLessonModel.class)
public interface IMyLessonModel {

	String getLessonId();
	String getName();
	String getDescription();
	Integer getSequence();
	Integer getOpenTests();
	Boolean getHasOpenTests();

}

/*       S.D.G.       */
