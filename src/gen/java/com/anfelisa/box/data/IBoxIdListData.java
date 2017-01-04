package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxIdListModel;

@JsonDeserialize(as=BoxIdListData.class)
public interface IBoxIdListData extends IBoxIdListModel, IDataContainer {

}

/*       S.D.G.       */
