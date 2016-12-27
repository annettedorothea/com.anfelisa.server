package com.anfelisa.test.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.ITestModel;

@JsonDeserialize(as=TestCreationData.class)
public interface ITestCreationData extends ITestModel, IDataContainer {

}

/*       S.D.G.       */
