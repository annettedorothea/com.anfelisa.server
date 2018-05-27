package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScheduledCardIdModel;

@JsonDeserialize(as=ScheduledCardIdData.class)
public interface IScheduledCardIdData extends IScheduledCardIdModel, IDataContainer {

}

/*       S.D.G.       */
