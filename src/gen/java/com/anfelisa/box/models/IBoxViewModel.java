package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxViewModel.class)
public interface IBoxViewModel {

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

}

/*       S.D.G.       */
