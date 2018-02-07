package com.anfelisa.course.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.ICourseIdModel;

@JsonDeserialize(as=CourseIdData.class)
public interface ICourseIdData extends ICourseIdModel, IDataContainer {

}

/*       S.D.G.       */
