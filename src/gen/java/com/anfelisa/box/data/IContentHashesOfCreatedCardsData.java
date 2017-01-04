package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IContentHashesOfCreatedCardsModel;

@JsonDeserialize(as=ContentHashesOfCreatedCardsData.class)
public interface IContentHashesOfCreatedCardsData extends IContentHashesOfCreatedCardsModel, IDataContainer {

}

/*       S.D.G.       */
