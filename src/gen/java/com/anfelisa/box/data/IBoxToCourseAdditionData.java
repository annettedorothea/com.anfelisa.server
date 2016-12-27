package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxOfCourseModel;

@JsonDeserialize(as=BoxToCourseAdditionData.class)
public interface IBoxToCourseAdditionData extends IBoxOfCourseModel, IDataContainer {

}

/*       S.D.G.       */
