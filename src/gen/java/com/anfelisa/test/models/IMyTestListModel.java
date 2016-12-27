package com.anfelisa.test.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=MyTestListModel.class)
public interface IMyTestListModel {


	java.util.List<com.anfelisa.test.models.IMyTestModel> getMyTestList();

}

/*       S.D.G.       */
