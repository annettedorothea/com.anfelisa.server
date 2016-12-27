package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICardOfBoxModel;

@JsonDeserialize(as=CardOfBoxCreationData.class)
public interface ICardOfBoxCreationData extends ICardOfBoxModel, IDataContainer {

}

/*       S.D.G.       */
