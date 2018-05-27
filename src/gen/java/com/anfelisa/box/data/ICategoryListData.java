package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.ICategorySelectionListModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryListData.class)
public interface ICategoryListData extends ICategorySelectionListModel, IDataContainer {

}

/*       S.D.G.       */
