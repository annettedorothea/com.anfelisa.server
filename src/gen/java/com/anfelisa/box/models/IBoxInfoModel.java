package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxInfoModel.class)
public interface IBoxInfoModel {

	Integer getTodaysCards();
	Integer getTotalCards();
	Integer getReinforceCards();
	Integer getMyCards();
	Integer getDaysBehindSchedule();
	String getCategoryName();
	Integer getMaxInterval();
	Integer getQuality0Count();
	Integer getQuality1Count();
	Integer getQuality2Count();
	Integer getQuality3Count();
	Integer getQuality4Count();
	Integer getQuality5Count();
	String getBoxId();
	String getUserId();
	org.joda.time.DateTime getToday();

}

/*       S.D.G.       */
