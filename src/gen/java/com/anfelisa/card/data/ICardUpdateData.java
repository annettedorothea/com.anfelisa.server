package com.anfelisa.card.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.card.models.ICardUpdateModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardUpdateData.class)
public interface ICardUpdateData extends ICardUpdateModel, IDataContainer {

}

/*       S.D.G.       */
