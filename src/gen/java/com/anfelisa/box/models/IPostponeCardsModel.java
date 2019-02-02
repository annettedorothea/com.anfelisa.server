package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=PostponeCardsModel.class)
public interface IPostponeCardsModel {

	Integer getDays();
	void setDays(Integer days);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	String getUserId();
	void setUserId(String userId);
	
	org.joda.time.DateTime getToday();
	void setToday(org.joda.time.DateTime today);
	
	
}

/*       S.D.G.       */
