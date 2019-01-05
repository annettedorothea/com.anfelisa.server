package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardIdListModel;

@JsonDeserialize(as=CardIdListData.class)
public interface ICardIdListData extends ICardIdListModel, IDataContainer {
}

/*       S.D.G.       */
