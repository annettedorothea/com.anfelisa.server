package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICategorySelectionListModel;

@JsonDeserialize(as=CategoryListData.class)
public interface ICategoryListData extends ICategorySelectionListModel, IDataContainer {

}

/*       S.D.G.       */
