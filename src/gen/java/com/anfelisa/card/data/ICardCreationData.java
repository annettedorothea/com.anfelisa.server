package com.anfelisa.card.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.card.models.ICardModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardCreationData.class)
public interface ICardCreationData extends ICardModel, IDataContainer {

}

/*       S.D.G.       */
