package com.anfelisa.course.models;

import org.joda.time.DateTime;

@SuppressWarnings("unused")
public interface ICourseModel {

	Integer getId();
	String getName();
	String getDescription();
	Integer getSequence();
	Boolean getIsPublic();
	String getAuthor();

}

/*       S.D.G.       */
