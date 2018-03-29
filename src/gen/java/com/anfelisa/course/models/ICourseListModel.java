package com.anfelisa.course.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CourseListModel.class)
public interface ICourseListModel {

	java.util.List<com.anfelisa.course.models.ICourseModel> getCourseList();

}

/*       S.D.G.       */
