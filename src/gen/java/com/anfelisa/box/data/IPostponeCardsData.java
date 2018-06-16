package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IPostponeCardsModel;
import com.anfelisa.box.models.ITodayModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=PostponeCardsData.class)
public interface IPostponeCardsData extends IPostponeCardsModel, ITodayModel, IDataContainer {

}

/*       S.D.G.       */
