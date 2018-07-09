package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardModel;
import com.anfelisa.user.models.IUserIdModel;

@JsonDeserialize(as=CardCreationData.class)
public interface ICardCreationData extends ICardModel, IUserIdModel, IDataContainer {

}

/*       S.D.G.       */
