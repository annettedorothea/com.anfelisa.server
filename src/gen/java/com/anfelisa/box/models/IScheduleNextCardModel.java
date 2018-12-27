package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScheduleNextCardModel.class)
public interface IScheduleNextCardModel extends com.anfelisa.box.models.IScheduledCardModel{

	String getUserId();
	String getBoxId();

}

/*       S.D.G.       */
