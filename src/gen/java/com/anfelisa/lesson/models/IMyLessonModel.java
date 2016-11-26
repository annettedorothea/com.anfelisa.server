package com.anfelisa.lesson.models;

import org.joda.time.DateTime;

@SuppressWarnings("unused")
public interface IMyLessonModel {

	Integer getId();
	String getName();
	String getDescription();
	Integer getSequence();
	Integer getOpenTests();
	Boolean getHasOpenTests();

}

/*       S.D.G.       */
