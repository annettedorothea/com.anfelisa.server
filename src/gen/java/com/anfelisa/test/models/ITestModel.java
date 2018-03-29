package com.anfelisa.test.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=TestModel.class)
public interface ITestModel {

	Integer getTestId();
	String getName();
	Integer getSequence();
	Integer getLessonId();
	String getHtml();
	String getAuthor();

}

/*       S.D.G.       */
