package com.anfelisa.course.models;

import org.joda.time.DateTime;

@SuppressWarnings("unused")
public interface IMyCourseModel {

	Integer getId();
	String getName();
	String getDescription();
	Integer getSequence();
	Boolean getIsPublic();
	String getAuthor();
	Integer getOpenTests();
	Boolean getHasOpenTests();

}

/*       S.D.G.       */
