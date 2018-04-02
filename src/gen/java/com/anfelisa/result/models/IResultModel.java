package com.anfelisa.result.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ResultModel.class)
public interface IResultModel {

	String getResultId();
	String getUsername();
	String getTestId();
	org.joda.time.DateTime getDate();
	String getJson();
	Integer getPoints();
	Integer getMaxPoints();

}

/*       S.D.G.       */
