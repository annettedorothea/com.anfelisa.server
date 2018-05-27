package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICardModel;

@JsonDeserialize(as=CardCreationData.class)
public interface ICardCreationData extends ICardModel, IDataContainer {

}

/*       S.D.G.       */
