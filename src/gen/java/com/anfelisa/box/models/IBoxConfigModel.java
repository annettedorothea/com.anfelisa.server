package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxConfigModel.class)
public interface IBoxConfigModel {

	Integer getBoxId();

	java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> getBoxOfCourseList();

}

/*       S.D.G.       */
