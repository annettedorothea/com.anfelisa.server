package com.anfelisa.test.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.ITestIdModel;

@JsonDeserialize(as=TestIdData.class)
public interface ITestIdData extends ITestIdModel, IDataContainer {

}

/*       S.D.G.       */
