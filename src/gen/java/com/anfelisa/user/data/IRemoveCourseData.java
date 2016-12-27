package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ICourseIdModel;
import com.anfelisa.user.models.IUsernameModel;

@JsonDeserialize(as=RemoveCourseData.class)
public interface IRemoveCourseData extends ICourseIdModel, IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
