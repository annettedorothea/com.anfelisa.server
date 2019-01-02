package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxListModel;

@JsonDeserialize(as=BoxListData.class)
public interface IBoxListData extends IBoxListModel, IDataContainer {
}

/*       S.D.G.       */
