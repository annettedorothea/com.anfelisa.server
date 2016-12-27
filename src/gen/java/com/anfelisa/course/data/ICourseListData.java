package com.anfelisa.course.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.ICourseListModel;

@JsonDeserialize(as=CourseListData.class)
public interface ICourseListData extends ICourseListModel, IDataContainer {

}

/*       S.D.G.       */
