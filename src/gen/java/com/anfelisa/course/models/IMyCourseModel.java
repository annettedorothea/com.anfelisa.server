package com.anfelisa.course.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=MyCourseModel.class)
public interface IMyCourseModel {

	String getCourseId();
	String getName();
	String getDescription();
	Integer getSequence();
	Boolean getIsPublic();
	String getAuthor();
	Integer getOpenTests();
	Boolean getHasOpenTests();

}

/*       S.D.G.       */
