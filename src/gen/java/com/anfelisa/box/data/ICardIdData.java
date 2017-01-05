package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICardIdModel;

@JsonDeserialize(as=CardIdData.class)
public interface ICardIdData extends ICardIdModel, IDataContainer {

}

/*       S.D.G.       */
