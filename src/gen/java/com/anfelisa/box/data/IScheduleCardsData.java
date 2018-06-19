package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScheduledCardsModel;
import com.anfelisa.box.models.IUserIdModel;
import com.anfelisa.box.models.IBoxIdModel;

@JsonDeserialize(as=ScheduleCardsData.class)
public interface IScheduleCardsData extends IScheduledCardsModel, IUserIdModel, IBoxIdModel, IDataContainer {

}

/*       S.D.G.       */
