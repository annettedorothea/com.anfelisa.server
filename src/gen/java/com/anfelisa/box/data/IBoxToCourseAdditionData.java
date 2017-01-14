package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxOfCourseModel;
import com.anfelisa.user.models.ICredentialsModel;

@JsonDeserialize(as=BoxToCourseAdditionData.class)
public interface IBoxToCourseAdditionData extends IBoxOfCourseModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
