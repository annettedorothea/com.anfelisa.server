package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IScheduledCardIdModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScheduledCardIdData.class)
public interface IScheduledCardIdData extends IScheduledCardIdModel, IDataContainer {

}

/*       S.D.G.       */
