package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.ICourseListModel;
import com.anfelisa.user.models.ICredentialsModel;

@JsonDeserialize(as=CourseSelectionData.class)
public interface ICourseSelectionData extends ICourseListModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
