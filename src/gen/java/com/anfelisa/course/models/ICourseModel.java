package com.anfelisa.course.models;

import org.joda.time.DateTime;

@SuppressWarnings("unused")
public interface ICourseModel {

	Long getId();
	String getName();
	String getDescription();
	Integer getSequence();
	Boolean getIsPublic();

}

/*       S.D.G.       */
