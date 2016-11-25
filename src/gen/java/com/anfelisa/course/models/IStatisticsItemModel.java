package com.anfelisa.course.models;

import org.joda.time.DateTime;

@SuppressWarnings("unused")
public interface IStatisticsItemModel {

	String getType();
	Boolean getIsBox();
	Integer getCount();
	Integer getDay();
	String getName();
	Integer getPoints();
	Integer getMaxPoints();
	Integer getRate();

}

/*       S.D.G.       */
