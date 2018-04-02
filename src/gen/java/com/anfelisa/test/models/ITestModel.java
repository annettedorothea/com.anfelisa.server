package com.anfelisa.test.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=TestModel.class)
public interface ITestModel {

	String getTestId();
	String getName();
	Integer getSequence();
	String getLessonId();
	String getHtml();
	String getAuthor();

}

/*       S.D.G.       */
