package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IBoxIdModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.IUserIdModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScheduleCardData.class)
public interface IScheduleCardData extends IScheduledCardModel, IUserIdModel, IBoxIdModel, IDataContainer {

}

/*       S.D.G.       */
