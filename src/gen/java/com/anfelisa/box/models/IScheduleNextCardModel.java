package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScheduleNextCardModel.class)
public interface IScheduleNextCardModel extends com.anfelisa.box.models.IScheduledCardModel{

	String getUserId();
	void setUserId(String userId);
	
	String getBoxId();
	void setBoxId(String boxId);
	

}

/*       S.D.G.       */
