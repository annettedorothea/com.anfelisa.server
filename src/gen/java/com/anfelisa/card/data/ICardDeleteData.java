package com.anfelisa.card.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.card.models.ICardDeleteModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardDeleteData.class)
public interface ICardDeleteData extends ICardDeleteModel, IDataContainer {

}

/*       S.D.G.       */
