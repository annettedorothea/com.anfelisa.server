package com.anfelisa.test.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=MyTestModel.class)
public interface IMyTestModel {

	String getTestId();
	String getName();
	Integer getSequence();
	Integer getResultCount();
	Boolean getHasResults();
	java.util.List<com.anfelisa.result.models.IResultAbstractModel> getResultAbstractList();

}

/*       S.D.G.       */
