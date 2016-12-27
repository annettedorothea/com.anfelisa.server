package com.anfelisa.course.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CourseIdModel.class)
public interface ICourseIdModel {

	Integer getCourseId();


}

/*       S.D.G.       */
