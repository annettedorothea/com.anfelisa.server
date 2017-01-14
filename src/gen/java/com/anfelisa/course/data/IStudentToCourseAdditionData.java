package com.anfelisa.course.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.IStudentOfCourseModel;
import com.anfelisa.user.models.ICredentialsModel;

@JsonDeserialize(as=StudentToCourseAdditionData.class)
public interface IStudentToCourseAdditionData extends IStudentOfCourseModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
