package com.anfelisa.test.models;

public interface IMyTestModel {

	Integer getTestId();
	String getName();
	Integer getSequence();
	Integer getResultCount();
	Boolean getHasResults();

	java.util.List<com.anfelisa.result.models.IResultAbstractModel> getResultAbstractList();

}

/*       S.D.G.       */
