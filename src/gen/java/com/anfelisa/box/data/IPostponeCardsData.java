package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IPostponeCardsModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=PostponeCardsData.class)
public interface IPostponeCardsData extends IPostponeCardsModel, IDataContainer {

}

/*       S.D.G.       */
