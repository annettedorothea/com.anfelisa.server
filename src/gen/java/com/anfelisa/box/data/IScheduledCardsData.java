package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScheduledCardsModel;

@JsonDeserialize(as=ScheduledCardsData.class)
public interface IScheduledCardsData extends IScheduledCardsModel, IDataContainer {
}

/*       S.D.G.       */
