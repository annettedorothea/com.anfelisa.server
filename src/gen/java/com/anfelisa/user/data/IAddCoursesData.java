package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ICourseSelectionModel;
import com.anfelisa.user.models.ICredentialsModel;
import com.anfelisa.user.models.IUsernameModel;

@JsonDeserialize(as=AddCoursesData.class)
public interface IAddCoursesData extends ICourseSelectionModel, ICredentialsModel, IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
