package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxInfoModel.class)
public interface IBoxInfoModel {

	Integer getTodaysCards();
	Integer getTotalCards();
	Integer getReinforceCards();
	Integer getMyCards();
	Integer getDaysBehindSchedule();
	String getBoxId();
	String getCategoryId();
	String getCategoryName();
	Integer getCategoryIndex();
	Integer getMaxInterval();

}

/*       S.D.G.       */
