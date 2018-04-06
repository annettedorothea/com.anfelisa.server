package com.anfelisa.course.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CourseModel.class)
public interface ICourseModel {

	String getCourseId();
	String getName();
	String getDescription();
	Integer getSequence();
	String getAuthor();

}

/*       S.D.G.       */
