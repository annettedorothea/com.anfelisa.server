package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxConfigModel.class)
public interface IBoxConfigModel {

	String getBoxId();
	java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> getBoxOfCourseList();
	java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> getExistingItems();

}

/*       S.D.G.       */
