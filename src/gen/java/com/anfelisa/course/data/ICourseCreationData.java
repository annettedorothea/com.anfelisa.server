package com.anfelisa.course.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.ICourseModel;

@JsonDeserialize(as=CourseCreationData.class)
public interface ICourseCreationData extends ICourseModel, IDataContainer {

}

/*       S.D.G.       */
