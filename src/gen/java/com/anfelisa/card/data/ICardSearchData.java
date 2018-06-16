package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardSearchModel;

@JsonDeserialize(as=CardSearchData.class)
public interface ICardSearchData extends ICardSearchModel, IDataContainer {

}

/*       S.D.G.       */
