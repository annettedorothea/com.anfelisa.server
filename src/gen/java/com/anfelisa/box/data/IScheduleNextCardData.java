package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScheduleNextCardModel;

@JsonDeserialize(as=ScheduleNextCardData.class)
public interface IScheduleNextCardData extends IScheduleNextCardModel, IDataContainer {
	void mapFrom(com.anfelisa.box.models.IScheduledCardModel model);
}

/*       S.D.G.       */
