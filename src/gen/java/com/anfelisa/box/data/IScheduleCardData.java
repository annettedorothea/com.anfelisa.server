package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.ITodayModel;
import com.anfelisa.box.models.IUserIdModel;
import com.anfelisa.box.models.IBoxIdModel;

@JsonDeserialize(as=ScheduleCardData.class)
public interface IScheduleCardData extends IScheduledCardModel, ITodayModel, IUserIdModel, IBoxIdModel, IDataContainer {

}

/*       S.D.G.       */
