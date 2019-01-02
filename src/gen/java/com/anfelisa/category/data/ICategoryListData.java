package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryListModel;

@JsonDeserialize(as=CategoryListData.class)
public interface ICategoryListData extends ICategoryListModel, IDataContainer {
}

/*       S.D.G.       */
