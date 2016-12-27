package com.anfelisa.test.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=TestIdModel.class)
public interface ITestIdModel {

	Integer getTestId();


}

/*       S.D.G.       */
