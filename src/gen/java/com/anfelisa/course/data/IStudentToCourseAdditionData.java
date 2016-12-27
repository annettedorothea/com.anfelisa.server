package com.anfelisa.course.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.IStudentOfCourseModel;

@JsonDeserialize(as=StudentToCourseAdditionData.class)
public interface IStudentToCourseAdditionData extends IStudentOfCourseModel, IDataContainer {

}

/*       S.D.G.       */
