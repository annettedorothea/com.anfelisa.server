package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICourseToBoxAdditionListModel;
import com.anfelisa.user.models.IUsernameModel;

@JsonDeserialize(as=BoxOfCourseListData.class)
public interface IBoxOfCourseListData extends ICourseToBoxAdditionListModel, IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
