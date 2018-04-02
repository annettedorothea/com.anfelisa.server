package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CourseIdModel.class)
public interface ICourseIdModel {

	String getCourseId();

}

/*       S.D.G.       */
