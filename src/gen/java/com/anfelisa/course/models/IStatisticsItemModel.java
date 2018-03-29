package com.anfelisa.course.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=StatisticsItemModel.class)
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
