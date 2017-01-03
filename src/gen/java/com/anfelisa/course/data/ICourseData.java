package com.anfelisa.course.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.ICourseModel;

@JsonDeserialize(as=CourseData.class)
public interface ICourseData extends ICourseModel, IDataContainer {

}

/*       S.D.G.       */
