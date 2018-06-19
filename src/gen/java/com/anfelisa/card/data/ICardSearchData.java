package com.anfelisa.card.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.card.models.ICardSearchModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardSearchData.class)
public interface ICardSearchData extends ICardSearchModel, IDataContainer {

}

/*       S.D.G.       */
