package com.anfelisa.course.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=StatisticsModel.class)
public interface IStatisticsModel {

	String getUsername();
	Integer getYear();
	Integer getMonth();
	Integer getPoints();
	Integer getMaxPoints();
	Integer getRate();


}

/*       S.D.G.       */
