package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IScheduledCardModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScheduledCardData.class)
public interface IScheduledCardData extends IScheduledCardModel, IDataContainer {

}

/*       S.D.G.       */
