package com.anfelisa.course.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CourseAbstractModel.class)
public interface ICourseAbstractModel {

	String getCourseName();
	String getCourseDescription();
	Boolean getIsPublic();
	String getCourseAuthor();
	String getCourseId();

}

/*       S.D.G.       */
