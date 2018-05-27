package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IDaysBehindModel;

@JsonDeserialize(as=RecalculateScheduledCardsData.class)
public interface IRecalculateScheduledCardsData extends IBoxModel, IDaysBehindModel, IDataContainer {

}

/*       S.D.G.       */
