package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IDaysBehindModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=RecalculateScheduledCardsData.class)
public interface IRecalculateScheduledCardsData extends IBoxModel, IDaysBehindModel, IDataContainer {

}

/*       S.D.G.       */
