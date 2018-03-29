package com.anfelisa.course.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CourseModel.class)
public interface ICourseModel {

	Integer getCourseId();
	String getName();
	String getDescription();
	Integer getSequence();
	Boolean getIsPublic();
	String getAuthor();

}

/*       S.D.G.       */
