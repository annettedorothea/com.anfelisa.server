package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICategorySelectionListModel;
import com.anfelisa.box.models.IUserIdModel;

@JsonDeserialize(as=CategoryListData.class)
public interface ICategoryListData extends ICategorySelectionListModel, IUserIdModel, IDataContainer {

}

/*       S.D.G.       */
