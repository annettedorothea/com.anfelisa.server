package com.anfelisa.test.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=TestListModel.class)
public interface ITestListModel {


	java.util.List<com.anfelisa.test.models.ITestModel> getTestList();

}

/*       S.D.G.       */
