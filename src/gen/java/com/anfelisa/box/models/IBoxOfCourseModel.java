package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxOfCourseModel.class)
public interface IBoxOfCourseModel {

	Integer getBoxId();
	Integer getCourseId();
	Boolean getAutoAdd();


}

/*       S.D.G.       */
