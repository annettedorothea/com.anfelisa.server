package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CourseToBoxAdditionModel.class)
public interface ICourseToBoxAdditionModel {

	String getBoxId();
	String getCourseId();
	Boolean getAutoAdd();
	String getName();

}

/*       S.D.G.       */
