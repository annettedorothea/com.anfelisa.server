package com.anfelisa.test.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.ICardContentHashListModel;
import com.anfelisa.test.models.ITestIdModel;

@JsonDeserialize(as=CardContentHashListData.class)
public interface ICardContentHashListData extends ICardContentHashListModel, ITestIdModel, IDataContainer {

}

/*       S.D.G.       */
