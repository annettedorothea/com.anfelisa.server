package com.anfelisa.result.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ResultSaveModel.class)
public interface IResultSaveModel {

	String getUsername();
	Integer getTestId();
	String getJson();
	Integer getPoints();
	Integer getMaxPoints();
	org.joda.time.DateTime getDate();


}

/*       S.D.G.       */
