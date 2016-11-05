package com.anfelisa.result.models;

import org.joda.time.DateTime;

@SuppressWarnings("unused")
public interface IResultModel {

	Integer getId();
	String getUsername();
	Integer getTestId();
	DateTime getDate();
	String getJson();
	Integer getPoints();
	Integer getMaxPoints();

}

/*       S.D.G.       */
