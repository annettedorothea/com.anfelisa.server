package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CourseToBoxAdditionListModel.class)
public interface ICourseToBoxAdditionListModel {

	Integer getBoxId();
	String getBoxName();

	java.util.List<com.anfelisa.box.models.ICourseToBoxAdditionModel> getCourseToBoxAdditionList();

}

/*       S.D.G.       */
