package com.anfelisa.course.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=MyCourseListModel.class)
public interface IMyCourseListModel {


	java.util.List<com.anfelisa.course.models.IMyCourseModel> getMyCourseList();

}

/*       S.D.G.       */
