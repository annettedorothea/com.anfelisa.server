package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardDeleteModel;
import com.anfelisa.user.models.IUserIdModel;

@JsonDeserialize(as=CardDeleteData.class)
public interface ICardDeleteData extends ICardDeleteModel, IUserIdModel, IDataContainer {

}

/*       S.D.G.       */
