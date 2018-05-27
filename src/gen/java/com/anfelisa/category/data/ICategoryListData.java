package com.anfelisa.category.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.category.models.ICategoryListModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryListData.class)
public interface ICategoryListData extends ICategoryListModel, IDataContainer {

}

/*       S.D.G.       */
