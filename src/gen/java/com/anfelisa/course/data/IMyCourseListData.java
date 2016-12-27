package com.anfelisa.course.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.IMyCourseListModel;
import com.anfelisa.user.models.IUsernameModel;

@JsonDeserialize(as=MyCourseListData.class)
public interface IMyCourseListData extends IMyCourseListModel, IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
