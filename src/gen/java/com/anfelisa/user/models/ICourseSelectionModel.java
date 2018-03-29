package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CourseSelectionModel.class)
public interface ICourseSelectionModel {

	java.util.List<Integer> getCourseIdList();

}

/*       S.D.G.       */
