package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardUpdateModel;
import com.anfelisa.user.models.IUserIdModel;

@JsonDeserialize(as=CardUpdateData.class)
public interface ICardUpdateData extends ICardUpdateModel, IUserIdModel, IDataContainer {

}

/*       S.D.G.       */
