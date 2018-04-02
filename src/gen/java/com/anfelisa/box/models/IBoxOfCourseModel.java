package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxOfCourseModel.class)
public interface IBoxOfCourseModel {

	String getBoxId();
	String getCourseId();
	Boolean getAutoAdd();

}

/*       S.D.G.       */
